import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

    }

    public static <T> T getInput(String text, T inputType) {
        final Scanner in = new Scanner(System.in);

        System.out.print(text);

        in.close();
    }
}
