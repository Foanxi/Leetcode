package easy;

public class T908_smallestRangeI {
    public int smallestRangeI(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int t:nums){
            max=Math.max(max,t);
            min=Math.min(min,t);
        }
        if (max-k<=min+k){
            return 0;
        }else return max-k-min-k;
    }

    public static void main(String[] args) {
        int[] nums = {0,10};
        System.out.println(new T908_smallestRangeI().smallestRangeI(nums, 2));
    }
}
