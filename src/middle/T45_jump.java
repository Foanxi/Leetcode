package middle;

/**
 * @author foanxi
 */
public class T45_jump {
    public int jump(int[] nums) {
        int curRange = 0;
        int nextRange = 0;
        int result = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextRange = Math.max(nextRange, i + nums[i]);
            if (i == curRange) {
                curRange = nextRange;
                result++;
            }
        }
        return result;
    }
}
