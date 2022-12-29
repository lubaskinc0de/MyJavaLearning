package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RandExample {
    public static void main(String[] args) {
        ArrayList<String> examples = randExamples();

        System.out.println(Arrays.toString(validateExamples(examples).toArray()));
    }

    private static int[] randNumbers() {
        int firstNumber = RandRange.randRange(2, 9);
        int secondNumber = RandRange.randRange(2, 9);

        if (firstNumber == secondNumber) {
            return randNumbers();
        }

        return new int[]{firstNumber, secondNumber};
    }

    private static String randExample() {
        int[] numbers = randNumbers();

        return String.format("%d*%d", numbers[0], numbers[1]);
    }

    public static ArrayList<String> randExamples() {
        ArrayList<String> examples = new ArrayList<String>();

        for (int i = 0; i < 15; i++) {
            examples.add(randExample());
        }

        return examples;
    }


    private static ArrayList<String> sortExamples(ArrayList<String> examples) {
        return (ArrayList<String>) examples.stream().map(v -> {
            String[] splitedV = v.split("\\*");

            List<Integer> intV =
                    Arrays.stream(splitedV).map(value -> Integer.parseInt(value))
                            .collect(Collectors.toList());

            int min = intV.get(0) > intV.get(1) ? intV.get(1) : intV.get(0);
            int max = min == intV.get(0) ? intV.get(1) : intV.get(0);

            return String.format("%d*%d", min, max);

        }).collect(Collectors.toList());
    }

    private static ArrayList<String> filterExamples(ArrayList<String> examples) {
        HashSet<String> filtered = new HashSet<String>(sortExamples(examples));

        ArrayList<String> filtered_array
                = (ArrayList<String>)filtered.stream()
                .collect(Collectors.toList());

        return filtered_array;
    }

    private static boolean isValidExamples(ArrayList<String> examples) {
        if (filterExamples(examples).size() < examples.size()) {
            return false;
        }

        return true;
    }

    private static ArrayList<String> validateExamples(ArrayList<String> examples) {

        if (isValidExamples(examples)) {
            return examples;
        }

        ArrayList<String> filtered = filterExamples(examples);
        int filteredSize = filtered.size();

        for (int i = 0; i < 15-filteredSize; i++) {
            filtered.add(randExample());
        }

        return validateExamples(filtered);
    }
}
