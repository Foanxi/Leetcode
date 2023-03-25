package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length<3)return result;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]>0)return result;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length-1;
            while (left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0){
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[left]);
                    integers.add(nums[right]);
                    result.add(integers);
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }else if (sum > 0)right--;
                else left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new T15_threeSum().threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer i:list){
                System.out.print(i+"\t");
            }
            System.out.println();
        }
    }
}
