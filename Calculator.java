import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;


public class Calculator {

    static final Map<String, BiFunction<Integer, Integer, Double>> ACTIONS =
            Map.of("+", Calculator::sum,
                    "-", Calculator::sub,
                    "*", Calculator::mul,
                    "/", Calculator::div);

    static final String WELCOME_MESSAGE = """
                Добро пожаловать!
                Это самый простейший калькулятор
                                
                Выберите желаемую операцию с числами:
                                
                (+) - Сложение
                (-) - Вычитание
                (*) - Умножение
                (/) - Деление
                       
                """;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        selectAction(in);
        in.close();
    }

    public static <T> T getInput(Scanner in, String text,
                                 Function<Scanner, T> getResult) {
        System.out.println(text);

        return getResult.apply(in);
    }

    public static void selectAction(Scanner scanner) {
        String action = getInput(scanner, WELCOME_MESSAGE, Scanner::nextLine);

        if (!ACTIONS.containsKey(action)) {
            throw new ArithmeticException(
                    "Вы должны выбрать корректное действие");
        }

        int numberOne = getInput(scanner, "Введите первое число: ",
                Scanner::nextInt);
        int numberTwo = getInput(scanner, "Введите второе число: ",
                Scanner::nextInt);

        double result = ACTIONS.get(action).apply(numberOne, numberTwo);

        System.out.printf("Результат: %.2f%n", result);
    }

    public static double sum(int numberOne, int numberTwo) {
        return (double) numberOne + numberTwo;
    }

    public static double sub(int numberOne, int numberTwo) {
        return (double) numberOne - numberTwo;
    }

    public static double div(int numberOne, int numberTwo) {
        return (double) numberOne / numberTwo;
    }

    public static double mul(int numberOne, int numberTwo) {
        return (double) numberOne * numberTwo;
    }
}
