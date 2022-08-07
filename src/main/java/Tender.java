import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Tender {

    public static Team getWinner(Order order, List<Team> teams) {
        int winner = 0;
        List<Team> teamsList=orderMatch(teams,order);
        BigDecimal price=teamsList.get(0).getPrice();
        for (int i = 1; i < teamsList.size(); i++) {
            if (price.compareTo(teamsList.get(i).getPrice())>0){
                 price= teamsList.get(i).getPrice();
                 winner=i;
            }
        }

        return teamsList.get(winner);
    }

    public static List<Team> orderMatch(List<Team> teams, Order order) {
        List<Team> orderMatch = new ArrayList<>();
        List<Skills> skills = order.vacancies.keySet().stream().toList();
        for (int j = 0; j < teams.size(); j++) {
            for (int i = 0; i < skills.size(); i++) {
                int orderCount = order.vacancies.get(skills.get(i));
                int teamCount = teamScope(teams.get(j)).get(skills.get(j));
                if (teamCount < orderCount)
                    break;
                if (i == skills.size() - 1)
                    orderMatch.add(teams.get(j));
            }
        }
        return orderMatch;

    }

    public static Map<Skills, Integer> teamScope(Team team) {
        return team.builders.stream()
                .map(Builder::getSkills)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));


    }


}
