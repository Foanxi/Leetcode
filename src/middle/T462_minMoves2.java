package middle;


import java.util.Arrays;

/**
* 首先使用排序，然后依此求出x与每一个值的差距
*/
public class T462_minMoves2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ret = 0, x = nums[n / 2];
        for (int num : nums) {
            ret += Math.abs(num - x);
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = {1,0,0,8,6};
        System.out.println(new T462_minMoves2().minMoves2(nums));
    }
}
