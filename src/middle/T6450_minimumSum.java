package middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @author foanxi
 */
public class T6450_minimumSum {
    public int minimumSum(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int cur = 1;
        int size = 0;
        while (size < n) {
            while (set.contains(cur)) {
                cur++;
            }
            sum += cur;
            set.add(cur);
            set.add(k - cur);
            size++;
        }
        return sum;
    }
}
