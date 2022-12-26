package beginner;

public class TryCatch {
    public static void main(String[] args) {
        /*
        Нередко в процессе выполнения программы могут возникать ошибки,
        при том необязательно по вине разработчика.

        Некоторые из них трудно предусмотреть или предвидеть,
        а иногда и вовсе невозможно. Так, например, может неожиданно оборваться
        сетевое подключение при передаче файла.
        Подобные ситуации называются исключениями.

        В языке Java предусмотрены специальные средства для обработки подобных
        ситуаций. Одним из таких средств является конструкция
        try...catch...finally. При возникновении исключения в блоке try
        управление переходит в блок catch, который может обработать
        данное исключение. Если такого блока не найдено, то пользователю
        отображается сообщение о необработанном исключении, а дальнейшее
        выполнение программы останавливается. И чтобы подобной остановки
        не произошло, и надо использовать блок try..catch.

        try{
            int[] numbers = new int[3];
            numbers[4]=45;
            System.out.println(numbers[4]);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        System.out.println("Программа завершена");
         */

        try {
            div(1, 0);
        } catch (ArithmeticException ex) {
            System.out.println("arithmetic exception is catched!");
        } catch (Exception ex) {
            System.out.println("another exception is catched!");
        } finally {
            System.out.println("Programm is finished!");
        }
    }

    static double div(int x, int y) {
        return x / y;
    }
}
