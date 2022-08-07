import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Order order = new Order(new HashMap<>());
        Builder builder1 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(1000));
        Builder builder2 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(500));
        Builder builder3 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLUMBER)), new BigDecimal(400));
        Builder builder4 = new Builder(new ArrayList<>(List.of(Skills.PLUMBER)), new BigDecimal(1500));
        Builder builder5 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON)), new BigDecimal(900));
        Builder builder6 = new Builder(new ArrayList<>(Arrays.asList(Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(800));
        Builder builder7 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.PLASTERER)), new BigDecimal(700));
        Builder builder8 = new Builder(new ArrayList<>(Arrays.asList(Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(300));
        Builder builder9 = new Builder(new ArrayList<>(Arrays.asList(Skills.MASON, Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(800));
        Builder builder10 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(500));
        Builder builder11 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLUMBER)), new BigDecimal(1100));
        Builder builder12 = new Builder(new ArrayList<>(Arrays.asList(Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(1200));
        Builder builder13 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON)), new BigDecimal(1300));
        Builder builder14 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(800));
        Team team1 = new Team(new ArrayList<>());
        Team team2 = new Team(new ArrayList<>());
        Team team3 = new Team(new ArrayList<>());
        order.vacancies.put(Skills.WELDER, 2);
        order.vacancies.put(Skills.MASON, 3);
        order.vacancies.put(Skills.PLUMBER, 1);
        order.vacancies.put(Skills.PLASTERER, 1);
        team1.builders.addAll(new ArrayList<>(Arrays.asList(builder1, builder2, builder3, builder4, builder8, builder11, builder5, builder14)));
        team2.builders.addAll(new ArrayList<>(Arrays.asList(builder4, builder5, builder6, builder11, builder12, builder13, builder7)));
        team3.builders.addAll(new ArrayList<>(Arrays.asList(builder7, builder8, builder9, builder10, builder2, builder3)));
        List <Team> teamsList =new ArrayList<>(Arrays.asList(team1,team2,team3));
     //   HashMap<Skills, List<Builder>>buildersTeamList = Tender.buildBuildersTeamList(order, team1);
     //   System.out.println(buildersTeamList);
       // System.out.println(Tender.buildersInWork(order, team1));
      //  System.out.println(Tender.orderMatch(teamsList, order));
        System.out.println(Tender.getWinner(order,teamsList));


    }
}
