package middle;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class T75_sortColors {
    public void sortColors2(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                swap(nums, p1, i);
                if (p1 < p2) {
                    swap(nums, i, p2);
                }
                p1++;
                p2++;
            } else if (nums[i] == 1) {
                swap(nums, p2, i);
                p2++;
            }
        }
    }

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        for (int i = 0; i < nums.length && i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                swap(nums, p2, i);
                p2--;
            }
            if (nums[i] == 0) {
                swap(nums, p0, i);
                p0++;
            }
        }
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 0, 0, 0, 1, 1};
        new T75_sortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
