package nowcoder;

public class BM19 {
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0 && nums[i] > nums[i + 1]) {
                return i;
            }
            if (i == nums.length - 1 && nums[i] > nums[i - 1]) {
                return i;
            }
            if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BM19().findPeakElement(new int[]{2, 4, 1, 2, 7, 8, 4}));
    }
}
