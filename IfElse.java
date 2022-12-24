public class IfElse {
    public static void main(String[] args) {
        boolean condition = "Hello" == "Hello";

        checkCondition(condition);

        condition = "Hello1" == "Hello2";

        checkCondition(condition);
    }

    protected static void checkCondition(boolean condition) {
        if (condition) {
            // если condition - истинно

            System.out.println("condition is true!");
        } else if (2 + 2 == 4) {
            // если condition - ложно и 2 + 2 == 4

            System.out.println("2+2=4");
        } else {
            // если все условия выше - ложные

            System.out.println("all is false!!!!");
        }
    }
}
