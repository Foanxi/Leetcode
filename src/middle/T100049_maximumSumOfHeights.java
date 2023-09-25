package middle;

import java.util.Arrays;
import java.util.List;

/**
 * @author foanxi
 */
public class T100049_maximumSumOfHeights {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long res = 0;
        for (int i = 0; i < maxHeights.size(); i++) {
            res = Math.max(count(i, maxHeights, maxHeights.get(i)), res);
        }
        return res;
    }

    public long count(int index, List<Integer> maxHeights, int max) {
        long sum = max;
        // 从左边开始遍历尽可能贪心拿最大但不能超过上一次最大
        int pre = max;
        for (int j = index - 1; j >= 0; j--) {
            pre = Math.min(pre, maxHeights.get(j));
            sum += pre;
        }
        // 从右边开始
        pre = max;
        for (int j = index + 1; j < maxHeights.size(); j++) {
            pre = Math.min(pre, maxHeights.get(j));
            sum += pre;
        }
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 4, 4);
        System.out.println(new T100049_maximumSumOfHeights().maximumSumOfHeights(list));
    }
}
