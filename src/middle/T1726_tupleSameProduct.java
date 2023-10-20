package middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author foanxi
 */
public class T1726_tupleSameProduct {
    public int tupleSameProduct(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int cur = nums[i] * nums[j];
                map.merge(cur, 1, Integer::sum);
            }
        }
        for (int value : map.values()) {
            res += (value * (value - 1)) * 4;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T1726_tupleSameProduct().tupleSameProduct(new int[]{2, 3, 4, 6, 8, 12}));
    }
}
