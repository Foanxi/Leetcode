package hard;

import java.util.Stack;

/**
 * @author foanxi
 */
public class T84_largestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int[] newHeight = new int[heights.length+2];
        newHeight[0] = 0;
        newHeight[newHeight.length-1] =0;
        System.arraycopy(heights, 0, newHeight, 1, newHeight.length - 1 - 1);
        for (int i = 1; i < newHeight.length; i++) {
            // 如果当前遍历的柱子的高度大于之前的，则直接入栈，因为要找到应当是限制于我们最大矩形的
            // 比我们高的柱子可以容纳因此可以直接跳过
            if (newHeight[i] > newHeight[stack.peek()]) {
                stack.push(i);
            }
            // 如果相等，我们则需要替换当前，这样可以找到更远的位置
            else if (newHeight[i] == newHeight[stack.peek()]) {
                stack.pop();
                stack.push(i);
            }
            // 如果当前遍历的柱子的高度要低于之前的，此时就应该弹出之前的，也即找到比之前柱子小的第一个柱子
            else {
                while (!stack.isEmpty() && newHeight[i] < newHeight[stack.peek()]) {
                    int temp = stack.pop();
                    if (!stack.isEmpty()) {
                        int h = newHeight[temp];
                        int w = i - stack.peek() - 1;
                        result = Math.max((h * w), result);
                    }
                }
                stack.push(i);
            }
        }
        return result;
    }
}
