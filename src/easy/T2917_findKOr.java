package easy;

import java.util.Arrays;

public class T2917_findKOr {
    public int findKOr(int[] nums, int k) {
        int sum = 0;
        int index = 1;
        Arrays.sort(nums);
        for (int i = 0; i < Integer.toBinaryString(nums[nums.length - 1]).length(); i++) {
            int count = 0;
            for (int n : nums) {
                String binaryString = Integer.toBinaryString(n);
                if (binaryString.length() - index >= 0 && binaryString.charAt(binaryString.length() - index) == '1') {
                    count++;
                }
                if (count >= k) {
                    sum += (int) Math.pow(2, index - 1);
                    break;
                }
            }
            index++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new T2917_findKOr().findKOr(new int[]{7, 12, 9, 8, 9, 15}, 4));
    }
}
