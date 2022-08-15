import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Builder builder = (Builder) o;
        return Objects.equals(skills, builder.skills) && Objects.equals(salary, builder.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skills, salary);
    }

    @Override
    public String toString() {
        return  '\n'+"Builder{" +
                "skills=" + skills +
                ", salary=" + salary +
                '}';
    }
}
