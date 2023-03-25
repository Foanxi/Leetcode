package middle;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author foanxi
 */
public class T435_eraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int right = intervals[0][1];
        int delete = -1;
        for (int[] nums:intervals){
            if (nums[0]<right){
                delete++;
            }
            right = nums[1];
        }
        return intervals.length-delete;
    }
}
