package easy;

public class T34_searchRange {
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int leftborder=-1;
        int rightborder=-1;
        while (left<=right){
            int middle=(left+right)/2;
            int midNum=nums[middle];
            if (midNum<target){
                left=middle+1;
                rightborder=left;
            }
            else if (midNum>target){
                right=middle-1;
                leftborder=right;
            }
        }
        return new int[]{leftborder+1,rightborder-1};
    }

    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int[] ints = new T34_searchRange().searchRange(nums, 8);
        System.out.println(ints[0]+","+ints[1]);
    }
}
