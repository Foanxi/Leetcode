package middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author foanxi
 */
public class T901_StockSpanner {
    // 构建一个从栈顶到栈底单调递增
    Stack<Integer> stack;
    Map<Integer, Integer> map;

    int count;

    public T901_StockSpanner() {
        stack = new Stack<>();
        map = new HashMap<>();
        count = 0;
    }

    public int next(int price) {
        map.put(price, count++);
        while (!stack.isEmpty()) {
            if (stack.peek() <= price) {
                stack.pop();
            } else {
                break;
            }
        }
        int res = count;
        if (!stack.isEmpty()) {
            res = count - map.get(stack.peek()) - 1;
        }
        stack.push(price);
        return res;
    }
}
