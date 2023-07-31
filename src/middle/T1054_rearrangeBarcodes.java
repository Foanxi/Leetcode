package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author foanxi
 */
public class T1054_rearrangeBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] res = new int[barcodes.length];
        // 统计次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : barcodes) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int evenIndex = 0;
        int oddIndex = 1;
        int halfLength = barcodes.length / 2;
        for (Integer num : map.keySet()) {
            Integer count = map.get(num);
            while (count > 0 && count <= halfLength && oddIndex < res.length) {
                res[oddIndex] = num;
                count--;
                oddIndex += 2;
            }
            while (count > 0) {
                res[evenIndex] = num;
                count--;
                evenIndex += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T1054_rearrangeBarcodes().rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2})));
    }
}
