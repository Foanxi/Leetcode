package easy;

import java.util.Arrays;
import java.util.List;

/**
 * @author foanxi
 */
public class T100031_sumIndicesWithKSetBits {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (hammingWeight(i) == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }

    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new T100031_sumIndicesWithKSetBits().sumIndicesWithKSetBits(Arrays.asList(5, 10, 1, 5, 2), 1));
    }
}
