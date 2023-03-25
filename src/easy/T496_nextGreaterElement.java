package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class T496_nextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int index = stack.pop();
                if (map.containsKey(nums2[index])){
                    result[map.get(nums2[index])] = nums2[i];
                }
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T496_nextGreaterElement().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
