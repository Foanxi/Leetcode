package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T2357_minimumOperations {
    public int minimumOperations2(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[nums.length - 1] == 0) {
                return result;
            } else if (nums[i] != 0) {
                result++;
                int temp = nums[i];
                for (int j = i; j < nums.length; j++) {
                    nums[j] -= temp;
                }
            }
        }
        return result;
    }

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            set.add(num);
        }
        return set.size();
    }


    public static void main(String[] args) {
        System.out.println(new T2357_minimumOperations().minimumOperations(new int[]{1, 5, 0, 3, 5}));
    }
}
