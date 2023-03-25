package middle;

/**
 * @author foanxi
 */
public class T376_wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int count = 1;
        int preDiff = 0;
        int curdDiff;
        for (int cur = 0; cur < nums.length - 1; cur++) {
            curdDiff = nums[cur + 1] - nums[cur];
            // 代表到达波峰或者波谷
            if ((preDiff <= 0 && curdDiff > 0) || (preDiff >= 0 && curdDiff < 0)) {
                count++;
                preDiff = curdDiff;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new T376_wiggleMaxLength().wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
    }
}
