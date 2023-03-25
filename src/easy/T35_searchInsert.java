package easy;

public class T35_searchInsert {
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int middle=(left+right)/2;
            int midNum=nums[middle];
            if (midNum<target)left=middle+1;
            else if (midNum>target)right=middle-1;
            else return middle;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(new T35_searchInsert().searchInsert(nums, 7));
    }
}
