import java.util.HashMap;
import java.util.List;

public class Order {
    public HashMap<Skills, Integer> vacancies;

    public Order(HashMap<Skills, Integer> vacancies) {
        this.vacancies = vacancies;
    }

    public HashMap<Skills, Integer> getVacancies() {
        return vacancies;
    }

    @Override
    public String toString() {
        return "Order{" +
                "vacancies=" + vacancies +
                '}';
    }
}
