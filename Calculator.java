import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Calculator {
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);

        selectAction(in);
        closeIn(in);
    }

    public static <T> T getInput(Scanner in, String text,
                                 Function<Scanner, T> getResult) {

        System.out.println(text);

        return getResult.apply(in);
    }

    public static void closeIn(Scanner in) {
        in.close();
    }

    public static void selectAction(Scanner scanner) {
        final Map<String, BiFunction<Integer, Integer, Float>> actions =
                new HashMap<>() {{
                    put("+", Calculator::sum);
                    put("-", Calculator::sub);
                    put("*", Calculator::mul);
                    put("/", Calculator::div);
                }};

        final String action = getInput(scanner, """
                Добро пожаловать!
                Это самый простейший калькулятор
                                
                Выберите желаемую операцию с числами:
                                
                (+) - Сложение
                (-) - Вычитание
                (*) - Умножение
                (/) - Деление
                       
                """, Scanner::nextLine
        );

        if (!(String.join("", actions.keySet()).contains(action))) {
            throw new ArithmeticException("Вы должны выбрать корректное " +
                    "действие");
        }

        final int numberOne = getInput(scanner, "Введите первое число: ",
                Scanner::nextInt);

        final int numberTwo = getInput(scanner, "Введите второе число: ",
                Scanner::nextInt);

        final BiFunction<Integer, Integer, Float> actionCallback =
                actions.get(action);

        final Float result = actionCallback.apply(numberOne, numberTwo);

        System.out.printf("Результат: %.2f", result);
    }

    public static float sum(int numberOne, int numberTwo) {
        return (float) (numberOne + numberTwo);
    }

    public static float sub(int numberOne, int numberTwo) {
        return (float) (numberOne - numberTwo);
    }

    public static float div(int numberOne, int numberTwo) {
        return (float) (numberOne / numberTwo);
    }

    public static float mul(int numberOne, int numberTwo) {
        return (float) (numberOne * numberTwo);
    }
}
