package offer;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class T49 {
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.add(1L);
        int res = 0;
        for (int i = 0; i <= n - 1; ++i) {
            long cur = queue.poll();
            res = (int) cur;
            if (!set.contains(2 * cur)) {
                queue.add(2 * cur);
                set.add(2 * cur);
            }
            if (!set.contains(3 * cur)) {
                queue.add(3 * cur);
                set.add(3 * cur);
            }
            if (!set.contains(5 * cur)) {
                queue.add(5 * cur);
                set.add(5 * cur);
            }
        }
        return res;
    }

    public int nthUglyNumber2(int n) {
        Set<Integer> set = new HashSet<>();
        int cur = 2;
        set.add(1);
        while (set.size() <= n) {
            if ((cur % 2 == 0 && set.contains(cur / 2)) || (cur % 3 == 0 && set.contains(cur / 3)) || (cur % 5 == 0 && set.contains(cur / 5))) {
                set.add(cur);
                if (set.size() == n) {
                    return cur;
                }
            }
            cur++;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new T49().nthUglyNumber(10));
    }
}
