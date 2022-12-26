package beginner;

import java.util.Arrays;

public class RecursiveMethods {
    public static void main(String[] args) {
        System.out.println(sum(1,2,3,4));
    }

    static int sum(int... nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return nums[0] + sum(Arrays.copyOfRange(nums, 1, nums.length));
    }
}
