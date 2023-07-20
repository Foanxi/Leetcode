package middle;

/**
 * @author hujinxu
 */
public class T918_maxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int $1 = 1;
        int tempMax = nums[0];
        int tempMin = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            tempMax = Math.max(nums[i], tempMax + nums[i]);
            max = Math.max(tempMax, max);
            tempMin = Math.min(nums[i], tempMin + nums[i]);
            min = Math.min(tempMin, min);
            sum += nums[i];
        }
        return sum == min ? max : Math.max(max, sum - min);
    }

    public static void main(String[] args) {
        System.out.println(new T918_maxSubarraySumCircular().maxSubarraySumCircular(new int[]{-3, -2, -3}));
    }
}
