import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class OrderTest {
    private Order order;
    private HashMap<Skills,Integer> request;
    private  Builder builder1=new Builder (new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLASTERER,Skills.PLUMBER)),new BigDecimal(1000));
    private  Builder builder2=new Builder (new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.PLASTERER,Skills.PLUMBER)),new BigDecimal(500));
    private  Builder builder3=new Builder (new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLUMBER)),new BigDecimal(400));
    private  Builder builder4=new Builder (new ArrayList<>(Arrays.asList(Skills.PLUMBER)),new BigDecimal(1500));
    private  Builder builder5=new Builder (new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON)),new BigDecimal(900));
    private  Builder builder6=new Builder (new ArrayList<>(Arrays.asList( Skills.PLASTERER,Skills.PLUMBER)),new BigDecimal(800));
    private  Builder builder7=new Builder (new ArrayList<>(Arrays.asList(Skills.WELDER,  Skills.PLASTERER)),new BigDecimal(700));
    private  Builder builder8=new Builder (new ArrayList<>(Arrays.asList(Skills.PLASTERER,Skills.PLUMBER)),new BigDecimal(300));
    private  Builder builder9=new Builder (new ArrayList<>(Arrays.asList( Skills.MASON, Skills.PLASTERER,Skills.PLUMBER)),new BigDecimal(800));
    private  Builder builder10=new Builder (new ArrayList<>(Arrays.asList(Skills.WELDER,  Skills.PLASTERER,Skills.PLUMBER)),new BigDecimal(500));
    private  Builder builder11=new Builder (new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLUMBER)),new BigDecimal(1100));
    private  Builder builder12=new Builder (new ArrayList<>(Arrays.asList( Skills.PLASTERER,Skills.PLUMBER)),new BigDecimal(1200));
    private  Builder builder13=new Builder (new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON)),new BigDecimal(1300));
    private  Builder builder14=new Builder (new ArrayList<>(Arrays.asList(Skills.WELDER, Skills.MASON, Skills.PLASTERER,Skills.PLUMBER)),new BigDecimal(800));
    private  Team team1;
    private  Team team2;
    private  Team team3;

    @Before
    private void setUp()  {
       order.vacancies.put(Skills.WELDER, 2);
       order.vacancies.put(Skills.MASON, 3);
       order.vacancies.put(Skills.PLUMBER, 1);
       order.vacancies.put(Skills.PLASTERER, 1);
        team1.builders.addAll(new ArrayList<>(Arrays.asList(builder1, builder2, builder3,builder4, builder8, builder11,builder5,builder14)));
        team2.builders.addAll(new ArrayList<>(Arrays.asList(builder4, builder5, builder6,builder11, builder12, builder13,builder7)));
        team3.builders.addAll(new ArrayList<>(Arrays.asList(builder7, builder8, builder9,builder10, builder2, builder3)));
    }
    @Test
    public void TestOrder(){

    }
}