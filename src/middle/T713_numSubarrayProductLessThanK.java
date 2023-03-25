package middle;

public class T713_numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums={10,5,2,6};
        System.out.println(new T713_numSubarrayProductLessThanK().numSubarrayProductLessThanK(nums, 100));
    }
}
