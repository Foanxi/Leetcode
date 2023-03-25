package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author foanxi
 */
public class T39_combinationSum {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return result;
    }

    public void backTracking(int[] candidates, int target, int startIndex) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            if (target - candidates[i]<0){
                break;
            }
            backTracking(candidates, target - candidates[i], i);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        System.out.println(new T39_combinationSum().combinationSum(nums, 7));
    }
}
