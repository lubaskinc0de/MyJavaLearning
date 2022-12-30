package oop;

public class ObjectsAsMethodParams {
    public static void main(String[] args) {
        /*
        Объекты классов, как и данные примитивных типов, могут передаваться в
        методы. Однако в данном случае есть одна особенность - при передаче
        объектов в качестве значения передается копия ссылки на область в
        памяти, где расположен этот объект. Рассмотрим небольшой пример.
        Пусть у нас есть следующий класс Person:

        public class Program{

            public static void main(String[] args) {

                Person kate = new Person("Kate");
                System.out.println(kate.getName());     // Kate
                changeName(kate);
                System.out.println(kate.getName());     // Alice
            }
            static void changeName(Person p){
                p.setName("Alice");
            }
        }
        class Person{

            private String name;

            Person(String name){
                this.name = name;
            }
            public void setName(String name){
                this.name = name;
            }
            public String getName(){
                return this.name;
            }
        }

        Здесь в метод changeName передается объект Person, у которого изменяется
        имя. Так как в метод будет передаваться копия ссылки на область памяти,
        в которой находится объект Person, то переменная kate и параметр p
        метода changeName будут указывать на один и тот же объект в памяти.
        Поэтому после выполнения метода у объекта kate, который передается
        метод, будет изменено имя с "Kate" на "Alice".

        От этого случая следует отличать другой случай:

        public class Program{

            public static void main(String[] args) {

                Person kate = new Person("Kate");
                System.out.println(kate.getName());     // Kate
                changePerson(kate);
                System.out.println(kate.getName());     // Kate - изменения не произошло
                                                // kate хранит ссылку на старый объект
            }
            static void changePerson(Person p){
                p = new Person("Alice");    // p указывает на новый объект
                p.setName("Ann");
            }
            static void changeName(Person p){
                p.setName("Alice");
            }
        }
        class Person{

            private String name;

            Person(String name){
                this.name = name;
            }
            public void setName(String name){
                this.name = name;
            }
            public String getName(){
                return this.name;
            }
        }

        В метод changePerson также передается копия ссылки на объект Person.
        Однако в самом методе мы изменяем не отдельные значения объекта,
        а пересоздаем объект с помощью конструктора и оператора new.
        В результате в памяти будет выделено новое место для нового объекта
        Person, и ссылка на этот объект будет привоена параметру p:

        static void changePerson(Person p){
            p = new Person("Alice");    // p указывает на новый объект
            p.setName("Ann");           // изменяется новый объект
        }

        То есть после создания нового объекта Person параметр p и переменная
        kate в методе main будут хранить ссылки на разные объекты. Переменная
        kate, которая передавалась в метод, продолжит хранить ссылку на старый
        объект в памяти. Поэтому ее значение не меняется.

         */

        User lubaskin = new User("LUBASKIN10", "sjsjss@gmail.com",
                "aaaacatsdogs");

        System.out.println(lubaskin.showPassword());

        changeUserPassword(lubaskin, "catsdogs123");

        System.out.println(lubaskin.showPassword());
        lubaskin.sendMessage("Hello!");

    }

    public static void changeUserPassword(User user, String newPassword) {
        user.setPassword(newPassword);
    }
}

class Email {

    private String address;

    Email(String address) {
        this.address = address;
    }

    public void send(String msg) {
        System.out.printf("Message successfully sended to %s******!%s",
                address.substring(0,
                5), "\n");
    }
}

class User {
    private String password;
    private Email email;
    private String username;

    User(String username, String email, String password) {
        this.username = username;
        this.email = new Email(email);
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void sendMessage(String msg) {
        System.out.printf("Sending message to %s...%s", username, "\n");
        email.send(msg);
    }

    public String showPassword() {
        return String.format("%s*****", password.substring(0, 5));
    }
}
