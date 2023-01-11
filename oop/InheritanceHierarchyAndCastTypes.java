package oop;

public class InheritanceHierarchyAndCastTypes {
    public static void main(String[] args) {
        /*
        В прошлой главе говорилось о преобразованиях объектов простых типов.

        Однако с объектами классов все происходит немного по-другому. Допустим,
        у нас есть следующая иерархия классов:

        public class Program{

            public static void main(String[] args) {

                Person tom = new Person("Tom");
                tom.display();
                Person sam = new Employee("Sam", "Oracle");
                sam.display();
                Person bob = new Client("Bob", "DeutscheBank", 3000);
                bob.display();
            }
        }
        // класс человека
        class Person {

            private String name;

            public String getName() { return name; }

            public Person(String name){

                this.name=name;
            }

            public void display(){

                System.out.printf("Person %s \n", name);
            }
        }
        // служащий некоторой компании
        class Employee extends Person{

            private String company;

            public Employee(String name, String company) {

                super(name);
                this.company = company;
            }
            public String getCompany(){ return company; }

            public void display(){

                System.out.printf("Employee %s works in %s \n", super.getName(), company);
            }
        }
        // класс клиента банка
        class Client extends Person{

            private int sum; // Переменная для хранения суммы на счете
            private String bank;

            public Client(String name, String bank, int sum) {

                super(name);
                this.bank=bank;
                this.sum=sum;
            }

            public void display(){

                System.out.printf("Client %s has account in %s \n", super.getName(), bank);
            }

            public String getBank(){ return bank; }
            public int getSum(){ return sum; }
        }

        В этой иерархии классов можно проследить следующую цепь наследования:
        Object (все классы неявно наследуются от типа Object) -> Person ->
        Employee|Client.

        Суперклассы обычно размещаются выше подклассов, поэтому на вершине
        наследования находится класс Object, а в самом низу Employee и Client.

        Объект подкласса также представляет объект суперкласса. Поэтому в
        программе мы можем написать следующим образом:

        Object tom = new Person("Tom");
        Object sam = new Employee("Sam", "Oracle");
        Object kate = new Client("Kate", "DeutscheBank", 2000);
        Person bob = new Client("Bob", "DeutscheBank", 3000);
        Person alice = new Employee("Alice", "Google");

        Это так называемое восходящее преобразование (от подкласса внизу к
        суперклассу вверху иерархии) или upcasting. Такое преобразование
        осуществляется автоматически.

        Обратное не всегда верно. Например, объект Person не всегда является
        объектом Employee или Client. Поэтому нисходящее преобразование или
        downcasting от суперкласса к подклассу автоматически не выполняется.
        В этом случае нам надо использовать операцию преобразования типов.

        Object sam = new Employee("Sam", "Oracle");

        // нисходящее преобразование от Object к типу Employee
        Employee emp = (Employee)sam;
        emp.display();
        System.out.println(emp.getCompany());

        В данном случае переменная sam приводится к типу Employee.

        И затем через объект emp мы можем обратиться к функционалу объекта
        Employee.

        Мы можем преобразовать объект Employee по всей прямой линии
        наследования от Object к Employee.

        Примеры нисходящих перобразований:

        Object kate = new Client("Kate", "DeutscheBank", 2000);
        ((Person)kate).display();

        Object sam = new Employee("Sam", "Oracle");
        ((Employee)sam).display();

        Но рассмотрим еще одну ситуацию:

        Object kate = new Client("Kate", "DeutscheBank", 2000);
        Employee emp = (Employee) kate;
        emp.display();

        // или так
        ((Employee)kate).display();

        В данном случае переменная типа Object хранит ссылку на объект Client.
        Мы можем без ошибок привести этот объект к типам Person или Client.
        Но при попытке преобразования к типу Employee мы получим ошибку во время
        выполнения. Так как kate не представляет объект типа Employee.

        Оператор instanceof

        В примере выше мы явно видим, что переменная kate - это ссылка на объект
        Client, а не Employee. Однако нередко данные приходят извне, и мы можем
        точно не знать, какой именно объект эти данные представляют.
        Соответственно возникает большая вероятность столкнуться с ошибкой.
        И перед тем, как провести преобразование типов, мы можем проверить,
        а можем ли мы выполнить приведение с помощью оператора instanceof:

        Object kate = new Client("Kate", "DeutscheBank", 2000);
        if(kate instanceof Employee){

            Employee employeeKate = (Employee) kate;
            employeeKate.display();
        }
        else{

            System.out.println("Conversion is invalid");
        }

        Выражение kate instanceof Employee проверяет, является ли переменная
        kate объектом типа Employee. Но так как в данном случае явно не
        является, то такая проверка вернет значение false, и преобразование
        не сработает.

        А выражение kate instanceof Client возвратило бы true

        Object kate = new Client("Kate", "DeutscheBank", 2000);

        if(kate instanceof Client){

            Client clientKate = (Client) kate;
            clientKate.display();
        }
        else{

            System.out.println("Conversion is invalid");
        }

        Следует отметить, что начиная с версии Java 16 мы можем упростить
        преобразование типов следующим образом:

        Object kate = new Client("Kate", "DeutscheBank", 2000);

        if(kate instanceof Client clientKate){

            clientKate.display();
        }
        else{

            System.out.println("Conversion is invalid");
        }
        Выражение

        kate instanceof Client clientKate

        Проверяет, представляет ли переменная kate класс Client, и
        если представляет (то есть оператор instanceof возвращает true),
        то создает переменную clientKate типа Client. И в дальнейшем мы можем
        использовать эту переменную clientKate и производить с ней различные
        операции.
         */

        Person employer = new BankEmployee("Peter", 34, 60,
                182, "Microsoft");

        // employer.openBankAccount(); // нельзя

        employer.sayMyName(); // но будет вызван переопределенный метод из
        // BankEmployee

        Person client = new BankClient("Alex", 34, 60, 182);
        client.sayMyName();

        Object sam = new BankClient("Sam", 32, 60, 182);

        if (sam instanceof BankClient newSam) {
            newSam.work(200);
        }
    }
}

abstract class Person {
    protected String name;

    public void sayMyName() {
        System.out.println(name);
    }

    protected int age;

    public int getAge() {
        return age;
    }

    protected int weight;

    public int getWeight() {
        return weight;
    }

    protected int height;

    public int getHeight() {
        return height;
    }

    Person(String name, int age, int weight, int height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    abstract void sayMyHobbies();
}

final class BankEmployee extends Person {
    private String companyName;

    BankEmployee(String name, int age, int weight, int height, String companyName) {
        super(name, age, weight, height);

        this.companyName = companyName;
    }

    @Override
    public void sayMyName() {
        System.out.printf("Hello, i'm %s!%n", name);
    }

    @Override
    void sayMyHobbies() {
        System.out.printf("I'm working in %s%n", companyName);
    }

    void openBankAccount(int sum, BankClient client) {
        int clientSum = client.getSum();

        if (clientSum < sum) {
            throw new IllegalArgumentException("Not enough money.");
        }

        client.setSum(clientSum - sum);

        System.out.printf("%s put to the bank %d dollars.%n", client.name,
                sum);
    }
}

final class BankClient extends Person {
    private int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    BankClient(String name, int age, int weight, int height) {
        super(name, age, weight, height);
    }

    @Override
    public void sayMyName() {
        System.out.printf("Hello, i'm %s!%n", name);
    }

    @Override
    void sayMyHobbies() {
        System.out.println("I love working");
    }

    void work(int salary) {
        System.out.printf("%s working..%n", name);
        System.out.printf("%s earned %d dollars.%n", name, salary);

        setSum(getSum() + salary);
    }
}
