package tasks;

import java.util.Random;

public class RandRange {
    public static void main(String[] args) {
        System.out.println(randRange(1, 2));
    }

    public static int randRange(int a, int b) {
        Random rand = new Random();

        int result = rand.nextInt(a, b + 1);

        return result;
    }
}
