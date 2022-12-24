package beginner;

import java.util.Scanner;

public class ConsoleInOut {
    public static void main(String[] args) {
        /*
         Консольный ввод вывод

         Для создания потока вывода в класс System определен объект out.

         В этом объекте определен метод println, который позволяет вывести на
         консоль некоторое значение с последующим \n

                 System.out.print() без \n

                 System.out.printf() форматированный вывод

         %x: для вывода шестнадцатеричных чисел

         %f: для вывода чисел с плавающей точкой

         %e: для вывода чисел в экспоненциальной форме, например, 1.3e+01

         %c: для вывода одиночного символа

         %s: для вывода строковых значений

         Ввод с консоли

         Для получения ввода с консоли в классе System определен объект in.
         Однако непосредственно через объект System.in не очень удобно работать,
         поэтому, как правило, используют класс Scanner, который, в свою очередь
         использует System.in. Например, напишем маленькую программу,
         которая осуществляет ввод чисел:

         Scanner in = new Scanner(System.in);
         System.out.print("Input a number: ");
         int num = in.nextInt();

         System.out.printf("Your number: %d \n", num);
         in.close();

         Так как класс Scanner находится в пакете java.util,
         то мы вначале его импортируем с помощью инструкции
         import java.util.Scanner.

         Для создания самого объекта Scanner в его конструктор передается
         объект System.in. После этого мы можем получать вводимые значения.
         Например, в данном случае вначале выводим приглашение к вводу
         и затем получаем вводимое число в переменную num.

         Чтобы получить введенное число, используется метод in.nextInt();,
         который возвращает введенное с клавиатуры целочисленное значение.

         Класс Scanner имеет еще ряд методов, которые позволяют получить введенные пользователем значения:

            next(): считывает введенную строку до первого пробела

            nextLine(): считывает всю введенную строку

            nextInt(): считывает введенное число int

            nextDouble(): считывает введенное число double

            nextBoolean(): считывает значение boolean

            nextByte(): считывает введенное число byte

            nextFloat(): считывает введенное число float

            nextShort(): считывает введенное число short
        */

        String name;
        byte age;
        float weight;
        float height;

        Scanner in = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");

        name = in.nextLine();

        System.out.print("Введите ваш возраст: ");

        age = in.nextByte();

        System.out.print("Введите ваш вес: ");

        weight = in.nextFloat();

        System.out.print("Введите ваш рост: ");

        height = in.nextFloat();

        System.out.printf("""
                        Сведения о вас
                                                 
                        Имя: %s
                        Возраст: %d
                        Вес: %f
                        Рост: %f
                        """,
                name, age, weight, height);

    }
}
