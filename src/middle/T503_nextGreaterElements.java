package middle;

import java.util.Arrays;
import java.util.Stack;

public class T503_nextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                result[stack.pop()] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T503_nextGreaterElements().nextGreaterElements(new int[]{1, 2, 1})));
    }
}
