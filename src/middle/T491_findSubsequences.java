package middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author foanxi
 */
public class T491_findSubsequences {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    public void backTracking(int[] nums, int startIndex) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || used[nums[i] + 100] == 1) {
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new T491_findSubsequences().findSubsequences(new int[]{4, 7, 6, 7}));
    }
}
