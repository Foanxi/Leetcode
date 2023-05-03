package middle;

public class T209_minSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int cur = 0;
        int res = Integer.MAX_VALUE;
        while (right <= nums.length) {
            if (cur >= target) {
                res = Math.min(right - left, res);
                cur -= nums[left];
                left++;
            } else {
                if (right >= nums.length) {
                    break;
                }
                cur = cur + nums[right];
                right++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        System.out.println(new T209_minSubArrayLen().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
