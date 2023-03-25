package middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author foanxi
 */
public class T78_subsets {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> temp = new LinkedList<>();

    /**
     * 思路一，传递每次子集的大小
     *
     * @param nums 集合
     * @return 返回所有子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i <= nums.length; i++) {
            backTracking(nums, i, 0);
        }
        return result;
    }

    public void backTracking(int[] nums, int len, int startIndex) {
        if (len == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            backTracking(nums, len - 1, i + 1);
            temp.removeLast();
        }
    }

    /**
     * 思路二，每次都直接记录下所有节点
     *
     * @param nums 集合
     * @return 返回所有子集
     */
    public List<List<Integer>> subsets2(int[] nums) {
        subsetsHelper(nums, 0);
        return result;
    }

    private void subsetsHelper(int[] nums, int startIndex) {
        //「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」
        result.add(new ArrayList<>(temp));
        for (int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            subsetsHelper(nums, i + 1);
            temp.removeLast();
        }
    }
}
