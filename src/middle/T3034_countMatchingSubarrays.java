package middle;

public class T3034_countMatchingSubarrays {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int res = 0;
        int subLen = pattern.length + 1;
        for (int i = 1; i <= nums.length - subLen + 1; i++) {
            boolean match = false;
            for (int j = 0; j < subLen - 1; j++) {
                switch (pattern[j]) {
                    case 0:
                        match = nums[i + j - 1] == nums[i + j];
                        break;
                    case 1:
                        match = nums[i + j - 1] < nums[i + j];
                        break;
                    case -1:
                        match = nums[i + j - 1] > nums[i + j];
                }
                if (!match) {
                    break;
                }
            }
            if (match) {
                res++;
            }
        }
        return res;
    }
}
