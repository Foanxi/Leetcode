package middle;

/**
 * @author foanxi
 */
public class T100088_maximumTripletValue {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((long) (nums[i] - nums[j]) * nums[k] > 0) {
                        res = Math.max(res, (long) (nums[i] - nums[j]) * nums[k]);
                    }
                }
            }
        }
        return res;
    }

    public long maximumTripletValue2(int[] nums) {
        int n = nums.length;
        long maxVal = 0;

        long[] maxRight = new long[n]; // 保存每个位置右侧的最大值
        maxRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        int maxLeft = nums[0]; // 保存左侧的最大值
        for (int j = 1; j < n - 1; j++) {
            maxLeft = Math.max(maxLeft, nums[j - 1]);
            long value = (maxLeft - nums[j]) * maxRight[j + 1];
            maxVal = Math.max(maxVal, value);
        }

        return maxVal;
    }

    public static void main(String[] args) {
        System.out.println(new T100088_maximumTripletValue().maximumTripletValue(new int[]{1000000, 1, 1000000}));
    }
}
