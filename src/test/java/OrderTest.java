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
    public Tender tender;

    @Before
    public void setUp() {
        builder1 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(1000));
        builder2 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(500));
        builder3 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLUMBER)), new BigDecimal(400));
        builder4 = new Builder(new ArrayList<>(List.of(Skills.PLUMBER)), new BigDecimal(1500));
        builder5 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON)), new BigDecimal(900));
        builder6 = new Builder(new ArrayList<>(Arrays.asList(Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(800));
        builder7 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.PLASTERER)), new BigDecimal(700));
        builder8 = new Builder(new ArrayList<>(Arrays.asList(Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(300));
        builder9 = new Builder(new ArrayList<>(Arrays.asList(Skills.MASON, Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(800));
        builder10 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(500));
        builder11 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLUMBER)), new BigDecimal(1100));
        builder12 = new Builder(new ArrayList<>(Arrays.asList(Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(1200));
        builder13 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON)), new BigDecimal(1300));
        builder14 = new Builder(new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLASTERER, Skills.PLUMBER)), new BigDecimal(800));
        order=new Order(new HashMap<>());
        order.vacancies.put(Skills.WELDER, 2);
        order.vacancies.put(Skills.MASON, 3);
        order.vacancies.put(Skills.PLUMBER, 1);
        order.vacancies.put(Skills.PLASTERER, 1);
        team1=new Team(new ArrayList<>(Arrays.asList(builder1, builder2, builder3, builder4, builder8, builder11, builder5, builder14)));
        team2=new Team(new ArrayList<>(Arrays.asList(builder4, builder5, builder6, builder11, builder12, builder13, builder7)));
        team3=new Team(new ArrayList<>(Arrays.asList(builder7, builder8, builder9, builder10, builder2, builder3)));
        teamsList=new ArrayList<>(Arrays.asList(team1, team2, team3));
        tender=new Tender(teamsList, order);
    }

    @Test
    public void testGetWinner() {
        Team expected = team1;
        Team actual = tender.getWinner();
        assertEquals(expected, actual);

    }
    @Test
    public void  testOrderMatch(){
        List<Team> expected =Arrays.asList(team1,team2);
        List<Team> actual=tender.orderMatch();
        assertEquals(expected,actual);
    }
    @Test
    public void testGetPrice(){
        BigDecimal expected=new BigDecimal(6500);
        BigDecimal actual=team1.getPrice();
        assertEquals(expected,actual);
    }



}