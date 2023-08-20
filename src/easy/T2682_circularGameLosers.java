package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author foanxi
 */
public class T2682_circularGameLosers {
    public int[] circularGameLosers(int n, int k) {
        boolean[] get = new boolean[n];
        int cur = 0;
        int round = 0;
        while (!get[cur]) {
            get[cur] = true;
            round++;
            cur = (cur + round * k) % n;
        }

        List<Integer> set = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!get[i]) {
                set.add(i);
            }
        }
        int[] res = new int[set.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = set.get(i) + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T2682_circularGameLosers().circularGameLosers(5, 2)));
    }
}
