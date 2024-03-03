package middle;

import java.util.ArrayList;
import java.util.List;

public class T100243_resultArray {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (list1.get(list1.size() - 1) > list2.get(list2.size() - 1)) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < list1.size(); i++) {
            res[i] = list1.get(i);
        }
        for (int j = 0; j < list2.size(); j++) {
            res[list1.size() + j] = list2.get(j);
        }
        return res;
    }
}
