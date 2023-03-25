package easy;

public class T27_removeElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length==1)return nums[0]==val?0:1;
        int next=0;
        int i=0;
        while (next<nums.length){
            if (nums[i]==val&&nums[next]!=val) {
                int temp=nums[i];
                nums[i] = nums[next];
                nums[next]=temp;
            } else if (nums[i]==val&&nums[next]==val) {
                next++;
                continue;
            }
            i++;
            next++;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums={3,2,2,3};
        System.out.println(new T27_removeElement().removeElement(nums, 3));
        for (int t:nums
             ) {
            System.out.println(t);
        }
    }
}
