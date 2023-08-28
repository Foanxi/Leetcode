package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author foanxi
 */
public class T57_insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> res = new ArrayList<>();
        // 先处理特殊情况
        if (newInterval[1] < intervals[0][0]) {
            res.add(newInterval);
            Collections.addAll(res, intervals);
            return res.toArray(new int[res.size()][]);
        } else if (newInterval[0] > intervals[intervals.length - 1][1]) {
            Collections.addAll(res, intervals);
            res.add(newInterval);
            return res.toArray(new int[res.size()][]);
        }
        boolean flag = false;
        int left = 0;
        int right;
        int index = 0;
        for (int i = 0; i < intervals.length; i++) {
            // 找到左区间开始处
            if (!flag && intervals[i][1] >= newInterval[0]) {
                flag = true;
                left = Math.min(intervals[i][0], newInterval[0]);
            }
            // 找到右区间开始处
            if (flag && intervals[i][0] > newInterval[1]) {
                flag = false;
                right = Math.max(newInterval[1], intervals[i - 1][1]);
                index = i;
                res.add(new int[]{left, right});
                break;
            }
            if (!flag) {
                res.add(intervals[i]);
            }
        }
        if (index != 0){
            for (int i = index; i < intervals.length; i++) {
                res.add(intervals[i]);
            }
        }
        // 此时说明走到终点还没有符合条件的
        if (flag) {
            res.add(new int[]{left, Math.max(newInterval[1], intervals[intervals.length - 1][1])});
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new T57_insert().insert(new int[][]{{1, 5}}, new int[]{5, 7})));
    }

}
