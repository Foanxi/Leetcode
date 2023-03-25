package easy;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class T1051_heightChecker {
    /**
     * 直接排序后遍历检查
     *
     * @param heights 身高数组
     * @return 升序排序后与原身高数组的差异个数
     */
    public int heightChecker(int[] heights) {
        int[] except = Arrays.copyOf(heights, heights.length);
        Arrays.sort(except);
        int diffSum = 0;
        for (int i = 0; i < except.length; i++) {
            if (except[i] != heights[i]) {
                diffSum++;
            }
        }
        return diffSum;
    }

    /**
     * 时间更快的写法，由于我们已经知道排序规则
     * 因此我们只需要对不同身高进行计数，然后检查前n个是否是相应的数字
     * 例如12323
     * 可以得知有1个1，2个2，2个3，因此第一个一定是1，然后是两个2，2个3
     * 因此只需要检查对应位置是否是相应的数字即可
     *
     * @param heights 身高数组
     * @return 升序排序后与原身高数组的差异个数
     */
    public int heightChecker2(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) {
                    count++;
                }
            }
        }
        return count;
    }
}
