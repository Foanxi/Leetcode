package easy;

import java.util.Stack;

public class T20_isValid {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c:chars){
            if (!stack.isEmpty()){
                if ((stack.peek()=='{'&&c=='}')||(stack.peek()=='('&&c==')')||(stack.peek()=='['&&c==']')){
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "{{{}{}}}";
        System.out.println(new T20_isValid().isValid(str));
    }
}
