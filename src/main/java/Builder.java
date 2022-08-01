import java.math.BigDecimal;
import java.util.List;

public class Builder {
   public List <Skills> skills;
   public BigDecimal salary;

    public Builder(List<Skills> skills, BigDecimal salary) {
        this.skills = skills;
        this.salary = salary;
    }

    public Builder(List<Skills> skills) {
        this.skills = skills;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "skills=" + skills +
                ", salary=" + salary +
                '}';
    }
}
