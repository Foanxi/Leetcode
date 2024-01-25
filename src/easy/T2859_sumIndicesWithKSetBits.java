package easy;

import java.util.Arrays;
import java.util.List;

public class T2859_sumIndicesWithKSetBits {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int ori = i;
            int count = 0;
            while (ori / 2 != 0) {
                if (ori % 2 == 1) {
                    count++;
                }
                if (count > k) {
                    break;
                }
                ori /= 2;
            }
            if (ori % 2 == 1) {
                count++;
            }
            if (count == k) {
                sum += nums.get(i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new T2859_sumIndicesWithKSetBits().sumIndicesWithKSetBits(Arrays.asList(5, 10, 1, 5, 2), 1));
    }
}
