package middle;

/**
 * @author foanxi
 */
public class T55_canJump {
    public boolean canJump(int[] nums) {
        int cover = 0;
        if (nums.length == 1) {
            return true;
        }
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(nums[i] + i, cover);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 超时
     */
    public boolean canJump2(int[] nums) {
        return backTracking(nums, 0);
    }

    public boolean backTracking(int[] nums, int curIndex) {
        int max = curIndex + nums[curIndex];

        if (max >= nums.length - 1) {
            return true;
        }

        for (int i = nums[curIndex]; i >= 1; i--) {
            if (backTracking(nums, curIndex + i)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new T55_canJump().canJump(new int[]{2,3,1,1,4}));
    }
}
