package oop;

public class AbstractClasses {
    public static void main(String[] args) {
        /*
        Кроме обычных классов в Java есть абстрактные классы. Абстрактный класс
        похож на обычный класс. В абстрактном классе также можно определить
        поля и методы, но в то же время нельзя создать объект или экземпляр
        абстрактного класса. Абстрактные классы призваны предоставлять базовый
        функционал для классов-наследников. А производные классы уже реализуют
        этот функционал.

        При определении абстрактных классов используется ключевое слово abstract

        public abstract class Human
            private String name;
            public String getName() { return name; }
        }

        Но главное отличие состоит в том, что мы не можем использовать
        конструктор абстрактного класса для создания его объекта. Например,
        следующим образом:

        Human h = new Human();

        Кроме обычных методов абстрактный класс может содержать абстрактные
        методы. Такие методы определяются с помощью ключевого слова abstract
        и не имеют никакой реализации:

        public abstract void display();

        Производный класс обязан переопределить и реализовать все абстрактные
        методы, которые имеются в базовом абстрактном классе. Также следует
        учитывать, что если класс имеет хотя бы один абстрактный метод, то
        данный класс должен быть определен как абстрактный.

        Зачем нужны абстрактные классы? Допустим, мы делаем программу для
        обслуживания банковских операций и определяем в ней три класса: Person,
        который описывает человека, Employee, который описывает банковского
        служащего, и класс Client, который представляет клиента банка.
        Очевидно, что классы Employee и Client будут производными от класса
        Person, так как оба класса имеют некоторые общие поля и методы.
        И так как все объекты будут представлять либо сотрудника, либо
        клиента банка, то напрямую мы от класса Person создавать объекты не
        будем. Поэтому имеет смысл сделать его абстрактным.

        public class Program{

            public static void main(String[] args) {

                Employee sam = new Employee("Sam", "Leman Brothers");
                sam.display();
                Client bob = new Client("Bob", "Leman Brothers");
                bob.display();
            }
        }
        abstract class Person {

            private String name;

            public String getName() { return name; }

            public Person(String name){

                this.name=name;
            }

            public abstract void display();
        }

        class Employee extends Person{

            private String bank;

            public Employee(String name, String company) {

                super(name);
                this.bank = company;
            }

            public void display(){

                System.out.printf("Employee Name: %s \t Bank: %s \n", super.getName(), bank);
            }
        }

        class Client extends Person
        {
            private String bank;

            public Client(String name, String company) {

                super(name);
                this.bank = company;
            }

            public void display(){

                System.out.printf("Client Name: %s \t Bank: %s \n", super.getName(), bank);
            }
        }

        Другим хрестоматийным примером является система геометрических фигур.
        В реальности не существует геометрической фигуры как таковой.
        Есть круг, прямоугольник, квадрат, но просто фигуры нет.
        Однако же и круг, и прямоугольник имеют что-то общее и являются фигурами

        // абстрактный класс фигуры
        abstract class Figure{

            float x; // x-координата точки
            float y; // y-координата точки

            Figure(float x, float y){

                this.x=x;
                this.y=y;
            }
            // абстрактный метод для получения периметра
            public abstract float getPerimeter();
            // абстрактный метод для получения площади
            public abstract float getArea();
        }
        // производный класс прямоугольника
        class Rectangle extends Figure
        {
            private float width;
            private float height;

            // конструктор с обращением к конструктору класса Figure
            Rectangle(float x, float y, float width, float height){

                super(x,y);
                this.width = width;
                this.height = height;
            }

            public float getPerimeter(){

                return width * 2 + height * 2;
            }

            public float getArea(){

                return width * height;
            }
        }

         */

        Square square = new Square(15, 15);

        square.render();

        System.out.println(square.getPerimeter());
        System.out.println(square.getArea());
    }
}

abstract class AbstractGeom {
    protected int width;
    protected int height;

    protected static String name;

    protected abstract String getName();

    AbstractGeom(int width, int height) {
    }

    public void render() {
        System.out.printf("This is %s!%n---------------%n%n",
                getName());
    }

    public abstract int getPerimeter();
    public abstract int getArea();
}

final class Square extends AbstractGeom {
    private static String name = "Square";

    @Override
    protected String getName() {
        return name;
    }

    Square(int width, int height) {
        super(width, height);

        if (width != height) {
            throw new IllegalArgumentException("Width and height must be " +
                    "equals in square!");
        }

        this.width = width;
        this.height = height;
    }

    @Override
    public void render() {
        super.render();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print('.');
            }
            System.out.print("\n");
        }
    }

    @Override
    public int getPerimeter() {
        return width * 4;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}
