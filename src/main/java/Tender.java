import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Tender {
    public List<Team> teams;
    public Order order;

    public Tender(List<Team> teams, Order order) {
        this.teams = teams;
        this.order = order;
    }

    public  Team getWinner() {
        List<Team> teamsList=orderMatch();
        return teamsList.stream()
                .min(Comparator.comparing(Team::getPrice))
                .orElseThrow(() ->new NotFoundMin("Not Found Min"));
    }

    public  List<Team> orderMatch() {
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

    public  Map<Skills, Integer> teamScope(Team team) {
        return team.builders.stream()
                .map(Builder::getSkills)
                .flatMap(Collection::stream)
                .collect(Collectors.toMap(Function.identity(), value -> 1, Integer::sum));


    }


}
