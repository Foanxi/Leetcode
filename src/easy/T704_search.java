package easy;

public class T704_search {
    public int search(int[] nums, int target) {
        if (nums.length==1)return nums[0]==target?0:-1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left+right)/2;
            if (nums[middle]<target)left=middle+1;
            else if (nums[middle]>target)right=middle-1;
            else return middle;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums ={-1,0,3,5,9,12};
        int[] num={0};
        System.out.println(new T704_search().search(nums, 0));
    }
}
