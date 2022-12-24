package beginner;

public class SwitchCase {
    public static void main(String[] args) {
        int condition = 3;

        switch (condition) {
            case 1:
                System.out.println("condition=1");
                // break что бы дальше не шла проверка на другие case
                break;
            case 2:
                System.out.println("condition=2");
                break;
            case 3:
                System.out.println("condition=3");
                break;
        }
    }
}
