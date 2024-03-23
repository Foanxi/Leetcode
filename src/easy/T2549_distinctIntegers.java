package easy;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class T2549_distinctIntegers {
    public int distinctIntegers2(int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        int res = 1;
        queue.add(n);
        Set<Integer> set = new HashSet<>();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i = poll - 1; i > 1; i--) {
                if (poll % i == 1 && !set.contains(i)) {
                    queue.add(i);
                    set.add(i);
                    res++;
                }
            }
        }
        return res;
    }

    public int distinctIntegers(int n) {
        if (n == 1) return 1;
        else return n - 1;
    }
}
