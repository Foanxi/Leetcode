package middle;

public class T1144_movesToMakeZigzag {
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(getOpNum(nums, 0), getOpNum(nums, 1));
    }

    public int getOpNum(int[] num, int pos) {
        int res = 0;
        for (int i = pos; i < num.length; i += 2) {
            int temp = 0;
            if (i - 1 >= 0) {
                temp = Math.max(temp, num[i] - num[i - 1] + 1);
            }
            if (i + 1 < num.length) {
                temp = Math.max(temp, num[i] - num[i + 1] + 1);
            }
            res += temp;
        }
        return res;
    }
}
