import java.util.*;
import java.util.stream.Stream;

public class Tender {
    private HashMap<Skills, Integer> test;
    private HashMap<Skills, List<Builder>> list;
  /* public static HashMap<Builder, Skills> buildersInWork(Order order, Team team){
        HashMap<Builder, Skills> buildersInWork = new HashMap<>();

        return
    }*/

    public static Team getWinner(Order order, List<Team> teams) {
        int winner = 0;

        for (int i = 0; i < teams.size(); i++)
            teams.get(i);

        return teams.get(winner);
    }

    public static HashMap<Builder, Skills> buildersInWork(Order order, Team team) {
        HashMap<Skills, List<Builder>> list = buildBuildersTeamList(order, team); //лист строителей по скилам
        List<Skills> skills = new ArrayList<>(order.vacancies.keySet()); //список навыков

        Collection<Integer> values = order.vacancies.values();
        List<Integer> sortedValues = values.stream().sorted().toList();

        HashMap<Builder, Skills> buildersInWork = new HashMap<>();

        for (int i = 0; i < skills.size(); i++) {
            int value = sortedValues.get(i);
            for (int k = 0; k < skills.size(); k++) {
                int orderValue = order.vacancies.get(skills.get(k));

                if (orderValue == value) {
                    for (int j = 0; j < value; j++) {
                        if (buildersInWork.containsKey(list.get(skills.get(k)).get(j))) {
                        } else {
                            buildersInWork.put(list.get(skills.get(k)).get(j), skills.get(k));
                        }
                    }
                }
            }
        }
        return buildersInWork;
    }

    public static HashMap<Skills, List<Builder>> reBuildBuildersTeamList(Order order, Team team) {
        HashMap<Skills, List<Builder>> list = buildBuildersTeamList(order, team);
        List<Skills> skills = new ArrayList<>(list.keySet());
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < skills.size(); i++) {
            count.add(list.get(skills.get(i)).size());
        }
        List<Integer> sortedCounts = count.stream().sorted().toList();
        HashMap<Skills, List<Builder>> reBuildList = new HashMap<>();
        for (int i = 0; i < sortedCounts.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                List<Builder> listCurrentBuilders = new ArrayList<>();
                if (sortedCounts.get(i).equals(list.get(skills.get(j)).size())) {//поиск в листе минимальное колличество строителей  специальности skills.get(j)
                    int min = list.get(skills.get(j)).get(0).skills.size();
                    int key = 0;
                    for (int k = 0; k < list.get(skills.get(j)).size(); k++) {
                        int currentValues = list.get(skills.get(j)).get(k).skills.size();
                        if (min > currentValues) {
                            min = currentValues;
                            key = j;                                            //поиск ключа строителя с миннимальными скилами
                        }
                    }

                    listCurrentBuilders.add(list.get(skills.get(j)).get(key));
                    // нужно реализовать удаление этого строителя из других мест
                }
                reBuildList.put(skills.get(j),listCurrentBuilders);
            }

        }
        return list;
    }


    public static HashMap<Skills, List<Builder>> buildBuildersTeamList(Order order, Team team) {
        HashMap<Skills, List<Builder>> list = new HashMap<>();
        List<Skills> listSkills = new ArrayList<>(order.vacancies.keySet());
        for (int i = 0; i < listSkills.size(); i++) {
            List<Builder> builderList = new ArrayList<>();
            for (int j = 0; j < team.builders.size(); j++) {
                if (team.builders.get(j).skills.contains(listSkills.get(i))) {
                    builderList.add(team.builders.get(j));
                }
            }
            list.put(listSkills.get(i), builderList);
        }
        return list;
    }


    public HashMap<Skills, Integer> getTest() {
        return test;
    }

    @Override
    public String toString() {
        return "Tender{" +
                "test=" + test +
                ", list=" + list +
                '}';
    }
}
