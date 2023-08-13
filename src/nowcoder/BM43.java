package nowcoder;

import java.util.Stack;

/**
 * @author foanxi
 */
public class BM43 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.add(node);
        if (minStack.isEmpty() || minStack.peek() >= node) {
            minStack.add(node);
        }
    }

    public void pop() {
        int pop = stack.pop();
        if (minStack.peek() == pop) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
