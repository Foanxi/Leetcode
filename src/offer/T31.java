package offer;

import java.util.Stack;

public class T31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 1){
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int leftIndex = 0;
        int rightIndex = 0;
        int count = 0;
        while (count <= popped.length){
            while (!stack.isEmpty() && stack.peek() == popped[rightIndex]){
                stack.pop();
                rightIndex++;
            }
            while (leftIndex < pushed.length && pushed[leftIndex] != popped[rightIndex]){
                stack.push(pushed[leftIndex]);
                leftIndex++;
            }
            if (leftIndex < pushed.length){
                stack.push(pushed[leftIndex]);
                leftIndex++;
            }

            count++;
        }
        return rightIndex == popped.length;
    }

    public static void main(String[] args) {
        System.out.println(new T31().validateStackSequences(new int[]{0,1}, new int[]{0,1}));
    }
}
