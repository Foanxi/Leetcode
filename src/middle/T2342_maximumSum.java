package middle;

import java.util.HashMap;
import java.util.Map;

public class T2342_maximumSum {

    public static void main(String[] args) {
        System.out.println(new T2342_maximumSum().maximumSum(new int[]{18, 43, 36, 13, 7}));
    }

    public int maximumSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = -1;
        for (int num : nums) {
            int sum = getSum(num);
            if (map.containsKey(sum)) {
                res = Math.max(res, map.get(sum) + num);
                if (map.get(sum) < num) {
                    map.put(sum, num);
                }
            } else {
                map.put(sum, num);
            }
        }
        return res;
    }

    public int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
