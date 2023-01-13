package oop;

public class Interfaces {
    public static void main(String[] args) {
        /*
        Механизм наследования очень удобен, но он имеет свои ограничения.
        В частности мы можем наследовать только от одного класса, в отличие,
        например, от языка С++, где имеется множественное наследование.

        В языке Java подобную проблему частично позволяют решить интерфейсы.
        Интерфейсы определяют некоторый функционал, не имеющий конкретной
        реализации, который затем реализуют классы, применяющие эти интерфейсы.
        И один класс может применить множество интерфейсов.

        Чтобы определить интерфейс, используется ключевое слово interface.
        Например:

        interface Printable{

            void print();
        }

        Данный интерфейс называется Printable. Интерфейс может определять
        константы и методы, которые могут иметь, а могут и не иметь
        реализации. Методы без  реализации похожи на абстрактные методы
        абстрактных классов. Так, в данном  случае объявлен один метод,
        который не имеет реализации.

        Все методы интерфейса не имеют модификаторов доступа, но фактически по
        умолчанию доступ public, так как цель интерфейса - определение
        функционала для реализации его классом. Поэтому весь функционал должен
        быть открыт для реализации.

        Чтобы класс применил интерфейс, надо использовать
        ключевое слово implements:

        public class Program{

            public static void main(String[] args) {

                Book b1 = new Book("Java. Complete Referense.", "H. Shildt");
                b1.print();
            }
        }
        interface Printable{

            void print();
        }
        class Book implements Printable{

            String name;
            String author;

            Book(String name, String author){

                this.name = name;
                this.author = author;
            }

            public void print() {

                System.out.printf("%s (%s) \n", name, author);
            }
        }

        В данном случае класс Book реализует интерфейс Printable. При этом надо
        учитывать, что если класс применяет интерфейс, то он должен реализовать
        все методы интерфейса, как в случае выше реализован метод print.
        Потом в методе main мы можем создать объект класса Book и вызвать его
        метод print. Если класс не реализует какие-то методы интерфейса,
        то такой класс должен быть определен как абстрактный, а его
        неабстрактные классы-наследники затем должны будут
        реализовать эти методы.

        В тоже время мы не можем напрямую создавать объекты интерфейсов,
        поэтому следующий код не будет работать:

        Printable pr = new Printable();
        pr.print();

        Одним из преимуществ использования интерфейсов является то, что они
        позволяют добавить в приложение гибкости. Например, в дополнение к
        классу Book определим еще один класс, который будет реализовывать
        интерфейс Printable:

        class Journal implements Printable {

            private String name;

            String getName(){
                return name;
            }

            Journal(String name){

                this.name = name;
            }
            public void print() {
                System.out.println(name);
            }
        }

        Класс Book и класс Journal связаны тем, что они реализуют интерфейс
        Printable. Поэтому мы динамически в программе можем создавать объекты
        Printable как экземпляры обоих классов:

        public class Program{

            public static void main(String[] args) {

                Printable printable = new Book("Java. Complete Reference", "H. Shildt");
                printable.print();      //  Java. Complete Reference (H. Shildt)
                printable = new Journal("Foreign Policy");
                printable.print();      // Foreign Policy
            }
        }
        interface Printable{

            void print();
        }
        class Book implements Printable{

            String name;
            String author;

            Book(String name, String author){

                this.name = name;
                this.author = author;
            }

            public void print() {

                System.out.printf("%s (%s) \n", name, author);
            }
        }
        class Journal implements Printable {

            private String name;

            String getName(){
                return name;
            }

            Journal(String name){

                this.name = name;
            }
            public void print() {
                System.out.println(name);
            }
        }

        Интерфейсы в преобразованиях типов

        Все сказанное в отношении преобразования типов характерно и для
        интерфейсов. Например, так как класс Journal реализует интерфейс
        Printable, то переменная типа Printable может хранить ссылку на
        объект типа Journal:

        Printable p = new Journal("Foreign Affairs");
        p.print();

        // Интерфейс не имеет метода getName, необходимо явное приведение
        String name = ((Journal)p).getName();

        System.out.println(name);

        И если мы хотим обратиться к методам класса Journal, которые определены
        не в интерфейсе Printable, а в самом классе Journal,
        то нам надо явным образом выполнить преобразование типов:
        ((Journal)p).getName();
         */

        Displayable workerDisplayable = new Worker("Peter");

        workerDisplayable.display();

        Workable worker = new Worker("Alex");

        worker.work();
    }
}

interface Workable {
    void work();
}

interface Displayable {
    void display();
}

class Worker implements Workable, Displayable {
    public String name;

    Worker(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.printf("%s is working!%n", name);
    }

    @Override
    public void display() {
        System.out.printf("I'm %s!%n", name);
    }
}
