package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author foanxi
 */
public class T40_combinationSum2 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        backTracking(candidates, target, 0);
        return result;
    }

    public void backTracking(int[] candidates, int target, int startIndex) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i >= 1 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(candidates[i]);
            used[i] = true;
            backTracking(candidates, target - candidates[i], i + 1);
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(new T40_combinationSum2().combinationSum2(nums, 8));
    }
}
