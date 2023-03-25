package easy;

public class T674_findLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        int curLen = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curLen++;
            } else {
                res = Math.max(curLen, res);
                curLen = 1;
            }
        }
        return Math.max(res,curLen);
    }
}
