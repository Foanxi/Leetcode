package easy;

public class T905_sortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        for (int right=0;right< nums.length;right++){
            if (nums[left]%2==1&&nums[right]%2!=1){
//                nums[left]=nums[left]^nums[right];
//                nums[right]=nums[left]^nums[right];
//                nums[left]=nums[left]^nums[right];
                int temp = nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
            }else if (nums[left]%2==0)left++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums ={0,1,2};
        int[] ints = new T905_sortArrayByParity().sortArrayByParity(nums);
        for (int r:ints){
            System.out.print(r+"\t");
        }
    }
}
