package middle;

/**
 * @author foanxi
 */
public class T80_removeDuplicates {

    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int num : nums) {
            if (cur < 2 || nums[cur] != num) {
                nums[cur++] = num;
            }
        }
        return cur;
    }

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int left = 2;
        int right = 2;
        while (right < n) {
            if (nums[left - 2] == nums[right]) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 2, 3, 3};
        int len = new T80_removeDuplicates().removeDuplicates(ints);
        for (int i = 0; i < len; i++) {
            System.out.println(ints[i]);
        }
    }
}
