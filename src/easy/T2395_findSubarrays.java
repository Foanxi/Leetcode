package easy;

import java.util.HashSet;
import java.util.Set;

public class T2395_findSubarrays {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length-1;++i){
            if (!set.add(nums[i]+nums[i+1])){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new T2395_findSubarrays().findSubarrays(new int[]{4, 2, 4}));
    }
}
