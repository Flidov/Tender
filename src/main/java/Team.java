import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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
        return totalCost(builders);
    }

    private BigDecimal totalCost(List <Builder> builders) {
      return    builders.stream()
                .map(Builder::getSalary)
                .reduce(new BigDecimal(0), BigDecimal::add);

    }

    @Override
    public String toString() {
        return "Team{" +
                "builders=" + builders +'\n' +
                "price=" + getPrice() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(builders, team.builders) && Objects.equals(price, team.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(builders, price);
    }
}
