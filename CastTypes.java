public class CastTypes {
    public static void main(String[] args) {
        /*
        Каждый базовый тип данных занимает определенное количество байт памяти.
        Это накладывает ограничение на операции, в которые вовлечены различные
        типы данных. Рассмотрим следующий пример:

        int a = 4;
        byte b = a; // ! Ошибка

        В данном коде мы столкнемся с ошибкой. Хотя и тип byte, и тип int
        представляют целые числа.
        Более того, значение переменной a, которое присваивается переменной
        типа byte, вполне укладывается в диапазон значений для типа byte
        (от -128 до 127).
        Тем не менее мы сталкиваемся с ошибкой на этапе компиляции.
        Поскольку в данном случае мы пытаемся присвоить некоторые данные,
        которые занимают 4 байта, переменной, которая занимает всего один байт.

        Тем не менее в программе может потребоваться, чтобы подобное преобразование было выполнено. В этом случае необходимо использовать операцию преобразования типов (операция ()):

        int a = 4;
        byte b = (byte)a;  // преобразование типов: от типа int к типу byte
        System.out.println(b); // 4

        Операция преобразования типов предполагает указание в скобках того типа,
        к которому надо преобразовать значение. Например,
        в случае операции (byte)a, идет преобразование данных типа int
        в тип byte. В итоге мы получим значение типа byte.

        Явные и неявные преобразования
        Когда в одной операции вовлечены данные разных типов,
        не всегда необходимо использовать операцию преобразования типов.
        Некоторые виды преобразований выполняются неявно, автоматически.

        Автоматически без каких-либо проблем производятся расширяющие
        преобразования (widening) - они расширяют представление объекта в памяти
        Например:

        byte b = 7;
        int d = b;  // преобразование от byte к int

        В данном случае значение типа byte, которое занимает в памяти 1 байт,
        расширяется до типа int, которое занимает 4 байта.

        Расширяющие автоматические преобразования представлены следующими
        цепочками:

        byte -> short -> int -> long

        int -> double

        short -> float -> double

        char -> int

        Автоматические преобразования с потерей точности

        Некоторые преобразования могут производиться автоматически между типами
        данных одинаковой разрядности или даже от типа данных с большей
        разрядностью к типа с меньшей разрядностью.

        Это следующие цепочки преобразований:

        int -> float, long -> float и long -> double.

        Они производятся без ошибок, но при преобразовании мы можем столкнуться
        с потерей информации.

        Например:

        int a = 2147483647;
        float b = a;            // от типа int к типу float
        System.out.println(b);  // 2.14748365E9

        Явные преобразования

        Во всех остальных преобразованиях примитивных типов явным образом
        применяется операция преобразования типов.

        Обычно это сужающие преобразования (narrowing) от типа с
        большей разрядностью к типу с меньшей разрядностью:

        long a = 4;
        int b = (int) a;

        Потеря данных при преобразовании

        При применении явных преобразований мы можем столкнуться с потерей
        данных. Например, в следующем коде у нас не возникнет никаких проблем:

        int a = 5;
        byte b = (byte) a;
        System.out.println(b);      // 5

        Число 5 вполне укладывается в диапазон значений типа byte,
        поэтому после преобразования переменная b будет равна 5.
        Но что будет в следующем случае:

        int a = 258;
        byte b = (byte) a;
        System.out.println(b);      // 2

        Результатом будет число 2. В данном случае число 258 вне диапазона для
        типа

        byte (от -128 до 127), поэтому произойдет усечение значения.
        Почему результатом будет именно число 2?

        Число a, которое равно 258,
        в двоичной системе будет равно 00000000 00000000 00000001 00000010.

        Значения типа byte занимают в памяти только 8 бит.
        Поэтому двоичное представление числа int усекается до 8 правых разрядов,
        то есть 00000010, что в десятичной системе дает число 2.

        Усечение рациональных чисел до целых

        При преобразовании значений с плавающей точкой к целочисленным
        значениям, происходит усечение дробной части:

        double a = 56.9898;
        int b = (int)a;

        Здесь значение числа b будет равно 56, несмотря на то, что число 57 было
        бы ближе к 56.9898.

        Чтобы избежать подобных казусов, надо применять функцию округления,
        которая есть в математической библиотеке Java:

        double a = 56.9898;
        int b = (int)Math.round(a);

        Преобразования при операциях

        Нередки ситуации, когда приходится применять различные операции,
        например, сложение и произведение, над значениями разных типов.
        Здесь также действуют некоторые правила:

        1 - если один из операндов операции относится к типу double, то и второй
         операнд преобразуется к типу double

        2 - если предыдущее условие не соблюдено, а один из операндов операции
        относится к типу float, то и второй операнд преобразуется к типу float

        3 - если предыдущие условия не соблюдены, один из операндов операции
        относится к типу long, то и второй операнд преобразуется к типу long

        иначе все операнды операции преобразуются к типу int

        Примеры преобразований:

        int a = 3;
        double b = 4.6;
        double c = a+b;

        Так как в операции участвует значение типа double,
        то и другое значение приводится к типу double и сумма двух значений
        a+b будет представлять тип double.

        Другой пример:

        byte a = 3;
        short b = 4;
        byte c = (byte)(a+b);

        Две переменных типа byte и short (не double, float или long),
        поэтому при сложении они преобразуются к типу int,
        и их сумма a+b представляет значение типа int.
        Поэтому если затем мы присваиваем эту сумму переменной типа byte,
        то нам опять надо сделать преобразование типов к byte.

        Если в операциях участвуют данные типа char, то они преобразуются в int:

        int d = 'a' + 5;
        System.out.println(d);  // 102
         */

        int b = 5;
        byte c = (byte)b;

        System.out.println(c);

        double v = 1 + 2.5;

        System.out.println(v);
    }
}
