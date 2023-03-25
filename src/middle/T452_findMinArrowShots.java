package middle;

import java.util.Arrays;
import java.util.Comparator;

public class T452_findMinArrowShots {
    /**
     * 通过比较左边界得到最小值
     *
     * @param points 气球坐标
     * @return 最少需要的射箭数
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            // 当前气球和前一个气球没有交差点，也即当前左边界大于前一个右边界
            if (points[i][0] > points[i - 1][1]) {
                result++;
            }
            // 否则就更新最小的右边界
            else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return result;
    }

    /**
     * 简略版，只需要关注左边界即可
     *
     * @param points
     * @return
     */
    public int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int result = 1;
        int right = points[0][1];
        for (int[] nums : points) {
            if (nums[0] > right) {
                result++;
                right = nums[1];
            }
        }
        return result;
    }
}
