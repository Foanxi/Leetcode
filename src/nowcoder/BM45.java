package nowcoder;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author foanxi
 */
public class BM45 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (size == 0 || size > num.length){
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && queue.peekLast() < num[i]) {
                queue.pollLast();
            }
            queue.add(num[i]);
        }
        list.add(queue.peek());
        for (int j = size; j < num.length; j++) {
            if (queue.peek().equals(num[j - size])) {
                queue.poll();
            }
            while (!queue.isEmpty() && queue.peekLast() < num[j]) {
                queue.pollLast();
            }
            queue.add(num[j]);
            list.add(queue.peek());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new BM45().maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
    }
}
