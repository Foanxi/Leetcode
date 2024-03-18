package easy;

public class T303_NumArray {

    int[] pre;

    public T303_NumArray(int[] nums) {
        pre = new int[nums.length];
        pre[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return pre[right];
        } else {
            return pre[right] - pre[left - 1];
        }
    }
}
