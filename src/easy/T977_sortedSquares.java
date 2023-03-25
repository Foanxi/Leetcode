package easy;

public class T977_sortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int point = result.length - 1;
        while (left <= right) {
            if (nums[left]*nums[left] > nums[right]*nums[right]) {
                result[point] = (int) Math.pow(nums[left], 2);
                left++;
            } else {
                result[point] = (int) Math.pow(nums[right], 2);
                right--;
            }
            point--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] ints = new T977_sortedSquares().sortedSquares(nums);
        for (int t : ints) {
            System.out.print(t + "\t");
        }
    }
}
