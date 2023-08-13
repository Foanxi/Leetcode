package nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author foanxi
 */
public class BM44 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else if (!stack.isEmpty()) {
                if (!map.get(c).equals(stack.peek())) {
                    return false;
                }
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
