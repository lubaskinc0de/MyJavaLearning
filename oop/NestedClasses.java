package oop;

public class NestedClasses {
    public static void main(String[] args) {
        /*
        Классы могут быть вложенными (nested), то есть могут быть определены
        внутри других классов. Частным случаем вложенных классов являются
        внутренние классы (inner class). Например, имеется класс Person,
        внутри которого определен класс Account:

        public class Program{

            public static void main(String[] args) {

                Person tom = new Person("Tom", "qwerty");
                tom.displayPerson();
                tom.account.displayAccount();
            }
        }
        class Person{

            private String name;
            Account account;

            Person(String name, String password){
                this.name = name;
                account = new Account(password);
            }
            public void displayPerson(){
                System.out.printf("Person \t Name: %s \t Password: %s \n", name, account.password);
            }

            public class Account{
                private String password;

                Account(String pass){
                    this.password = pass;
                }
                void displayAccount(){
                    System.out.printf("Account Login: %s \t Password: %s \n", Person.this.name, password);
                }
            }
        }

        Внутренний класс ведет себя как обычный класс за тем исключением,
        что его объекты могут быть созданы только внутри внешнего класса.

        Внутренний класс имеет доступ ко всем полям внешнего класса,
        в том числе закрытым с помощью модификатора private. Аналогично
        внешний класс имеет доступ ко всем членам внутреннего класса,
        в том числе к полям и методам с модификатором private.

        Ссылку на объект внешнего класса из внутреннего класса можно получить
        с помощью выражения Внешний_класс.this, например, Person.this.

        Объекты внутренних классов могут быть созданы только в том классе,
        в котором внутренние классы опеределены. В других внешних классах
        объекты внутреннего класса создать нельзя.

        Еще одной особенностью внутренних классов является то, что их можно
        объявить внутри любого контекста, в том числе внутри
        метода и даже в цикле.

        Статические вложенные классы

        Кроме внутренних классов также могут быть статические вложенные классы.
        Статические вложенные классы позволяют скрыть некоторую комплексную
        информацию внутри внешнего класса, доступ к статическому вложенному
        классу можно получить через Outer.Inner

        class Math{

            public static class Factorial{

                private int result;
                private int key;

                public Factorial(int number, int x){

                    result=number;
                    key = x;
                }

                public int getResult(){
                    return result;
                }

                public int getKey(){
                    return key;
                }
            }

            public static Factorial getFactorial(int x){

                int result=1;
                for (int i = 1; i <= x; i++){
                    result *= i;
                }
                return new Factorial(result, x);
            }
        }

        Здесь определен вложенный класс для хранения данных о вычислении
        факториала. Основные действия выполняет метод getFactorial,
        который возвращает объект вложенного класса.
        И теперь используем классы в методе main:


        public static void main(String[] args) {
            Math.Factorial fact = Math.getFactorial(6);
            System.out.printf("Факториал числа %d равен %d \n", fact.getKey(), fact.getResult());
        }
         */

        UserAccount lubaskin = new UserAccount(
                "LUBASKIN", "catsdogs",
                "myawesomeavatar", "jdj@gmail.com"
        );

        lubaskin.printUser();

        Math.Factorial fact = Math.getFactorial(3);

        System.out.printf(
                "Factorial %d is %d",
                fact.getBase(),
                fact.getResult());
    }
}

class UserAccount {
    private String username;
    private String password;
    public UserProfile profile;

    private Email email;

    UserAccount(String username, String password, String avatarB64,
                String email) {
        UserProfile userProfile = new UserProfile(avatarB64);
        Email userEmail = new Email(email);

        this.username = username;
        this.password = password;
        this.profile = userProfile;
        this.email = userEmail;
    }

    private class UserProfile {
        private String avatarB64;

        UserProfile(String avatar) {
            avatarB64 = avatar;
        }

        private void printUser() {
            System.out.printf("""
                    %s info:
                                       
                    username: %s;
                    password: %s;
                    avatar: %s;
                    email: %s;
                                    
                     """, username, username, password, avatarB64, getEmail());
        }
    }

    public static class Email {
        private String email;

        Email(String email) {
            this.email = email;
        }

        public String getEmail() {
            return email;
        }
    }

    public void printUser() {
        profile.printUser();
    }

    public String getEmail() {
        return email.getEmail();
    }
}

class Math {
    public static class Factorial {
        private int result;
        private int base;

        Factorial(int result, int base) {
            this.result = result;
            this.base = base;
        }

        public int getResult() {
            return result;
        }

        public int getBase() {
            return base;
        }
    }

    public static Factorial getFactorial(int base) {
        int factorial = getBaseFactorial(base);
        return new Factorial(factorial, base);
    }

    private static int getBaseFactorial(int base) {
        if (base == 1) {
            return base;
        }
        return base * getBaseFactorial(base - 1);
    }
}