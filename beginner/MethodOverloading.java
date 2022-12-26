package beginner;

import beginner.MethodParams;

public class MethodOverloading {
    public static void main(String[] args) {
        /*
        В программе мы можем использовать методы с одним и тем же именем,
        но с разными типами и/или количеством параметров.

        Такой механизм называется перегрузкой методов (method overloading).

        Например:

        public class Program{

            public static void main(String[] args) {

                System.out.println(sum(2, 3));          // 5
                System.out.println(sum(4.5, 3.2));      // 7.7
                System.out.println(sum(4, 3, 7));       // 14
            }
            static int sum(int x, int y){

                return x + y;
            }
            static double sum(double x, double y){

                return x + y;
            }
            static int sum(int x, int y, int z){

                return x + y + z;
            }
        }

        Здесь определено три варианта или три перегрузки метода sum(),
        но при его вызове в зависимости от типа и количества передаваемых
        параметров система выберет именно ту версию, которая наиболее подходит.


        Стоит отметить, что на перегрузку методов влияют количество
        и типы параметров. Однако различие в типе возвращаемого значения
        для перегрузки не имеют никакого значения.
        Например, в следующем случае методы различаются
        по типу возвращаемого значения:

        public class Program{

            public static void main(String[] args) {
                System.out.println(sum(2, 3));
                System.out.println(sum(4, 3));
            }

            static int sum(int x, int y){
                return x + y;
            }

            static double sum(int x, int y){
                return x + y;
             }
        }

        Однако перегрузкой это не будет считаться.
        Более того такая программа некорректна и попросту не скомилируется,
        так как метод с одним и тем же количеством и типом параметров определен
        несколько раз.
         */

        System.out.println(sum(1, 2, 3, 4));
    }

    static int sum(int x, int y) {
        return x + y;
    }

    static int sum(int... nums) {
        return MethodParams.sum(nums);
    }
}
