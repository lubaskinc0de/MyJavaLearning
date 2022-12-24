public class LogicalOperators {
    public static void main(String[] args) {
        lt();
        gt();
        eq();
        notEq();
        gtOrEq();
        ltOrEq();
        not();
        or();
        and();
    }

    protected static void print(Object text) {
        System.out.println(text);
    }

    protected static void lt() {
        /*
        Сравнение на 'меньше чем'
         */

        print(5 < 2); // false
        print(2 < 5); // true
    }

    protected static void gt() {
        /*
        Сравнение на 'больше чем'
         */

        print(5 > 2); // true
        print(2 > 5); // false
    }

    protected static void eq() {
        /*
        Сравнение на 'равенство'
         */

        print(5 == 5); // true
        print(2 == 5); // false
    }

    protected static void notEq() {
        /*
        Сравнение на 'неравенство'
         */

        print(5 != 5); // false
        print(2 != 5); // true
    }

    protected static void gtOrEq() {
        /*
        Сравненик на 'больше или равно'
         */

        print(5 >= 5); // true
        print(6 >= 5); // true
        print(2 >= 5); // false
    }

    protected static void ltOrEq() {
        /*
        Сравненик на 'меньше или равно'
         */

        print(5 <= 5); // true
        print(6 <= 5); // false
        print(2 <= 5); // true
    }

    protected static void not() {
        /*
        Логическое НЕ
         */

        print(!(5==5)); // false
        print(!(2==5)); // true
    }

    protected static void or() {
        /*
        Логическое ИЛИ
         */

        print(true || false); // true
        print(false || true); // false
    }

    protected static void and() {
        /*
        Логическое И
         */

        print(true && false); // false
        print(true && true); // true
    }
}
