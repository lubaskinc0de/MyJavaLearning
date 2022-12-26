package beginner;

public class Foreach {
    public static void main(String[] args) {
        /*
        foreach

        Специальная версия цикла for предназначена для перебора элементов в
        наборах элементов, например, в массивах и коллекциях.
        Она аналогична действию цикла foreach , который имеется в других языках
        программирования. Формальное ее объявление:

        for (тип_данных название_переменной : контейнер){
            // действия
        }

        Например:

        int[] array = new int[] { 1, 2, 3, 4, 5 };

        for (int i : array){
            System.out.println(i);
        }
         */

        int[] nums1 = {
                1, 2, 3, 4, 5, 6
        };

        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
