package middle;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class T2731_sumDistance {
    public int sumDistance(int[] nums, String s, int d) {
        long[] pos = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (s.charAt(i) == 'L') {
                pos[i] = nums[i] - d;
            } else {
                pos[i] = nums[i] + d;
            }
        }
        Arrays.sort(pos);
        long res = 0;
        final int mod = 1_000_000_007;
        for (int i = 1; i < nums.length; i++) {
            res += (pos[i] - pos[i - 1]) * i % mod * (nums.length - i) % mod;
            res %= mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new T2731_sumDistance().sumDistance(new int[]{-2, 0, 2}, "RLL", 3));
    }
}
