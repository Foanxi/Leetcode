package middle;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author foanxi
 */
public class T406_reconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        // 首先按照身高排
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return b[0] - a[0];
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        // 再按照从前往后遍历的k插入数组内
        for (int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[people.length][]);
    }
}
