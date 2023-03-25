package offer;

import java.util.Arrays;

public class T61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zero = 0;
        for (int num:nums){
            if (num == 0){
                zero++;
            }else {
                break;
            }
        }
        int need = 0;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i] != 0 && nums[i] == nums[i+1]){
                return false;
            }else if (nums[i]!= 0){
                need += nums[i+1] - nums[i] - 1;
            }
        }
        return need <= zero;
    }

    public static void main(String[] args) {
        System.out.println(new T61().isStraight(new int[]{0, 0, 8,5,4}));
    }
}
