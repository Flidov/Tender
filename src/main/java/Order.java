import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Order {
    public HashMap<Skills, Integer> vacancies;

    public Order(HashMap<Skills, Integer> vacancies) {
        this.vacancies = vacancies;
    }

    public HashMap<Skills, Integer> getVacancies() {
        return vacancies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(vacancies, order.vacancies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vacancies);
    }

    @Override
    public String toString() {
        return "Order{" +
                "vacancies=" + vacancies +
                '}';
    }
}
