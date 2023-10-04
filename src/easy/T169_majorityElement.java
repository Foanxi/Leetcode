package easy;

/**
 * @author foanxi
 */
public class T169_majorityElement {
    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 0;
        for (int num : nums) {
            if (num == cur) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                cur = num;
                count = 1;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new T169_majorityElement().majorityElement(new int[]{3, 2, 3}));
    }
}
