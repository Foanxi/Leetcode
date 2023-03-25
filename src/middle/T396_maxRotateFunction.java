package middle;

public class T396_maxRotateFunction {
    public int maxRotateFunction(int[] nums) {
        int max =Integer.MIN_VALUE;
        int j= nums.length-1;
        do{
            int sum=0;
            int temp=j;
            for (int i=0;i<nums.length;i++){
                sum+=nums[j]*i;
                j = (j+1) % nums.length;
            }
            max=Math.max(max,sum);
            j=(temp+1)% nums.length;
        }while (j% nums.length!=nums.length-1);
        return max;
    }

    public static void main(String[] args) {
        int[] nums={4,3,2,6};
        System.out.println(new T396_maxRotateFunction().maxRotateFunction(nums));
    }
}
