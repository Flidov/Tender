import java.math.BigDecimal;
import java.util.List;

public class Team {
    public List <Builder> builders;
    public BigDecimal price;


    public Team(List<Builder> builders) {
        this.builders = builders;
    }

    public List<Builder> getBuilders() {
        return builders;
    }

    public BigDecimal getPrice() {
        price=totalCost(builders);
        return price;
    }

    private BigDecimal totalCost(List <Builder> builders) {
        BigDecimal sum =new BigDecimal(0);
        for (int i = 1; i < builders.size(); i++) {
          sum=sum.add( builders.get(i).salary);
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Team{" +
                "builders=" + builders +
                ", price=" + price +
                '}';
    }
}
