package easy;

/**
 * @author foanxi
 */
public class T2562_findTheArrayConcVal {
    public long findTheArrayConcVal(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        long res = 0;
        while (left <= right) {
            if (left == right) {
                res += nums[right];
            } else {
                res += Integer.parseInt("" + nums[left] + nums[right]);
            }
            left++;
            right--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {7, 52, 2, 4};
        System.out.println(new T2562_findTheArrayConcVal().findTheArrayConcVal(num));
    }
}
