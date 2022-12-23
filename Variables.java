// модификатор доступа public, класс будет доступен из cmd
public class Variables {

    // публичный статический метод который вернет void
    public static void main(String[] args) {
        // переменная: тип имя_переменной
        /*
        Naming:

        Except for variables, all instance, class,
        and class constants are in mixed case with
        a lowercase first letter. Internal words start with uppercase
        */
        int number; // default: 0

        number = 10;

        int numberTwo = 25;

        System.out.println(number); // 10
        System.out.println(numberTwo); // 25

        int x = 10, y = 25;

        System.out.println(x);
        System.out.println(y);

        // тип высчитывается динамически
        var dynamicVariable = "I'm dynamic variable!";

        System.out.println(dynamicVariable);

        // константа
        final double PI = 3.14;

        System.out.println(PI);
    }
}
