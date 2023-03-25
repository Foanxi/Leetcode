package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T47_permuteUnique {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        // used数组标记false表示当前同一层前一个数字已经被使用过
        // used数组标记为true表示当前同一树枝已经被使用过
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracking(nums, used);
        return result;
    }

    public void backTracking(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
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
        System.out.println(new T47_permuteUnique().permuteUnique(new int[]{1, 1, 2}));
    }
}