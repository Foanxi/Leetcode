package middle;

import java.util.Arrays;

public class T2789_maxArrayValue {
    public long maxArrayValue(int[] nums) {
        long[] nums2 = new long[nums.length];
        for (int i=0;i<nums.length;++i){
            nums2[i] = nums[i];
        }
        for (int i = nums2.length - 2; i >= 0; --i) {
            if (nums2[i + 1] >= nums2[i]) {
                nums2[i] = nums2[i] + nums2[i + 1];
            }
        }
        Arrays.sort(nums2);
        return nums2[nums2.length - 1];
    }

}
