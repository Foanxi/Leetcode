package easy;

import java.util.ArrayList;
import java.util.List;

public class T228_summaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int pre = nums[0];
        int len = 1;
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (i != nums.length && nums[i] == nums[i - 1] + 1) {
                len++;
                continue;
            }
            if (len > 1) {
                res.add(pre + "->" + nums[i - 1]);
            } else {
                res.add(String.valueOf(pre));
            }
            if (i != nums.length) {
                pre = nums[i];
                len = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T228_summaryRanges().summaryRanges(new int[]{0, 2, 3, 4, 5, 7}));
    }
}
