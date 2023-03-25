package easy;

public class T283_moveZeroes {
    public void moveZeroes(int[] nums) {
        int left=0;
        for (int right=0;right< nums.length;right++){
            if (nums[right]!=0){
                nums[left]=nums[right];
                left++;
            }
        }
        for (int i=left;i<nums.length;i++){
            nums[i]=0;
        }
        for (int n:nums) {
            System.out.println(n);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,3,0,2,0};
        new T283_moveZeroes().moveZeroes(nums);
    }
}
