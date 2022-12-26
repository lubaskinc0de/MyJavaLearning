package beginner;

public class ThrowExc {
    public static void main(String[] args) {
        div(1, 0);
    }

    static double div(int a, int b) {
        if (a == 0 || b == 0) {

            // выкидываем исключение при делении на ноль
            throw new ArithmeticException("Деление на ноль!");
        }
        return a / b;
    }
}
