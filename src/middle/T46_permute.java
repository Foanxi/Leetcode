package middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author foanxi
 */
public class T46_permute {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] used = new boolean[nums.length];
        backTracking(nums, used);
        return result;
    }

    public void backTracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backTracking(nums, used);
                used[i] = false;
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new T46_permute().permute(new int[]{1, 2, 3}));
    }
}
