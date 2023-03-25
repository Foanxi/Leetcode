package offer;

import java.util.Stack;

public class T9 {
    public static void main(String[] args) {

    }
}

class CQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.isEmpty() && inStack.isEmpty()){
            return -1;
        }
        if (!outStack.isEmpty()){
            return outStack.pop();
        }
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
        return outStack.pop();
    }
}