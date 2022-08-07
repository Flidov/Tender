import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class OrderTest {
    public Order order;
    public Builder builder1;
    public Builder builder2;
    public Builder builder3;
    public Builder builder4;
    public Builder builder5;
    public Builder builder6;
    public Builder builder7;
    public Builder builder8;
    public Builder builder9;
    public Builder builder10;
    public Builder builder11;
    public Builder builder12;
    public Builder builder13;
    public Builder builder14;
    public Team team1;
    public Team team2;
    public Team team3;
    public List<Team> teamsList;

    @Before
    public void setUp() {
        Builder builder1 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(1000));
        Builder builder2 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(500));
        Builder builder3 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLUMBER)), new BigDecimal(400));
        Builder builder4 = new Builder(new ArrayList<>(Arrays.asList(Skills.PLUMBER)), new BigDecimal(1500));
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
        order.vacancies.put(Skills.WELDER, 2);
        order.vacancies.put(Skills.MASON, 3);
        order.vacancies.put(Skills.PLUMBER, 1);
        order.vacancies.put(Skills.PLASTERER, 1);
        team1.builders.addAll(new ArrayList<>(Arrays.asList(builder1, builder2, builder3, builder4, builder8, builder11, builder5, builder14)));
        team2.builders.addAll(new ArrayList<>(Arrays.asList(builder4, builder5, builder6, builder11, builder12, builder13, builder7)));
        team3.builders.addAll(new ArrayList<>(Arrays.asList(builder7, builder8, builder9, builder10, builder2, builder3)));
        teamsList.addAll(new ArrayList<>(Arrays.asList(team1, team2, team3)));
    }

    @Test
    public void getWinner() {
        Team expected = team3;
        Team actual = Tender.getWinner(order, teamsList);
        assertEquals(expected,actual);

    }


}