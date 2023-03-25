package offer;

public class T53_2 {
    public int missingNumber(int[] nums) {
        for (int i=0;i<nums.length;i++){
            if (nums[i] != i){
                return i;
            }
        }
        return nums[nums.length-1] + 1;
    }
}
