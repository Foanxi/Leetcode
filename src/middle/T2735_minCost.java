package middle;

import java.util.Arrays;

public class T2735_minCost {
    public long minCost(int[] nums, int x) {
        int len = nums.length;
        int[] f = Arrays.copyOf(nums, len);
        long res = getSum(f);
        for (int k = 1; k < len; k++) {
            for (int i = 0; i < len; i++) {
                f[i] = Math.min(f[i], nums[(i + k) % len]);
            }
            res = Math.min(res, (long) k * x + getSum(f));
        }
        return res;
    }

    public long getSum(int[] arr) {
        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new T2735_minCost().minCost(new int[]{31,25,18,59}, 27));
    }
}
