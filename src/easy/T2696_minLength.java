package easy;

import java.util.ArrayDeque;

public class T2696_minLength {
    public int minLength(String s) {
        ArrayDeque<Character> queue = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (charArray[i] == 'B' && !queue.isEmpty()) {
                if (queue.peekLast() == 'A') {
                    queue.pollLast();
                } else {
                    queue.addLast(charArray[i]);
                }
            } else if (charArray[i] == 'D' && !queue.isEmpty()) {
                if (queue.peekLast() == 'C') {
                    queue.pollLast();
                } else {
                    queue.addLast(charArray[i]);
                }
            } else {
                queue.addLast(charArray[i]);
            }
        }
        return queue.size();
    }
}
