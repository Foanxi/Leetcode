package nowcoder;

import java.util.Stack;

/**
 * @author foanxi
 */
public class BM49 {
    public int solve(String s) {
        Stack<Integer> integers = new Stack<>();
        Stack<Character> characters = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ')') {
                while (characters.peek() != '(') {
                    integers.add(handle(integers.pop(), integers.pop(), characters.pop()));
                }
                characters.pop();
            } else if (charArray[i] <= '9' && charArray[i] >= '0') {
                int sum = 0;
                while (i < charArray.length && charArray[i] <= '9' && charArray[i] >= '0') {
                    sum = sum * 10 + charArray[i] - '0';
                    i++;
                }
                integers.add(sum);
                i--;
            } else {
                while (!characters.isEmpty() && charArray[i] == '+' && characters.peek() == '*') {
                    integers.add(handle(integers.pop(), integers.pop(), characters.pop()));
                }
                while (!characters.isEmpty() && charArray[i] == '-' && (characters.peek() == '*' || characters.peek() == '-')) {
                    integers.add(handle(integers.pop(), integers.pop(), characters.pop()));
                }
                characters.add(charArray[i]);
            }
        }
        while (!characters.isEmpty()) {
            integers.add(handle(integers.pop(), integers.pop(), characters.pop()));
        }
        return integers.pop();
    }

    public int handle(int num1, int num2, char c) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BM49().solve("1-2-3"));
    }
}
