package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author foanxi
 */
public class T90_subsetsWithDup {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            boolean[] used = new boolean[nums.length];
            backTracking(nums, i, 0, used);
        }
        return result;
    }

    public void backTracking(int[] nums, int len, int startIndex, boolean[] used) {
        if (len == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            used[i] = true;
            backTracking(nums, len - 1, i + 1, used);
            used[i] = false;
            temp.removeLast();
        }
    }
}
