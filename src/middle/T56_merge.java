package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T56_merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int leftPos = intervals[0][0];
        int rightPos = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] <= rightPos) {
                rightPos = Math.max(interval[1], rightPos);
                continue;
            }
            int[] temp = new int[]{leftPos, rightPos};
            result.add(temp);
            leftPos = interval[0];
            rightPos = interval[1];
        }
        result.add(new int[]{leftPos, rightPos});
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new T56_merge().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
