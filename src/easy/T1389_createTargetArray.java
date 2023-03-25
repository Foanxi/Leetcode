package easy;

import java.util.LinkedList;

/**
 * @author foanxi
 */
public class T1389_createTargetArray {
    public int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
