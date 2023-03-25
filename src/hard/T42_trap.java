package hard;

import java.util.Stack;

public class T42_trap {
    public static void main(String[] args) {
        System.out.println(new T42_trap().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    /**
     * 单调栈方法
     *
     * @param height 墙的高度数组
     * @return 雨水数量
     */
    public int trap(int[] height) {
        int res = 0;
        // 单调栈保持出栈的时候是最小的，也即栈底到栈头是从大到小
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < height.length; i++) {
            // 如果更小则直接入栈，因为接不了雨水
            if (height[stack.peek()] > height[i]) {
                stack.push(i);
            }
            // 如果相等则替换
            else if (height[stack.peek()] == height[i]) {
                stack.pop();
                stack.push(i);
            }
            // 如果大于则一直出栈直到找到
            else {
                while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        // 得到左右两边高度小的
                        int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                        int w = i - stack.peek() - 1;
                        res += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }

    /**
     * 双指针优化法
     *
     * @param height 墙的高度数组
     * @return 雨水数量
     */
    public int trap3(int[] height) {
        int res = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        maxLeft[0] = height[0];
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        for (int j = height.length - 2; j >= 0; j--) {
            maxRight[j] = Math.max(maxRight[j + 1], height[j]);
        }

        for (int cur = 1; cur < height.length - 1; cur++) {
            int min = Math.min(maxLeft[cur], maxRight[cur]);
            res += min - height[cur];
        }

        return res;
    }

    /**
     * 按行求法
     *
     * @param height 墙的高度数组
     * @return 雨水数量
     */
    public int trap2(int[] height) {
        int max = getMax(height);
        int res = 0;
        for (int i = 1; i <= max; i++) {
            // 用于保存一块连续区域的雨水
            int temp = 0;
            boolean haveWall = false;
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= i) {
                    res += temp;
                    temp = 0;
                    haveWall = true;
                }
                // 当前区域相对于高度更矮
                else if (haveWall && height[j] < i) {
                    temp++;
                }
            }
        }
        return res;
    }

    public int getMax(int[] height) {
        int max = 0;
        for (int num : height) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
