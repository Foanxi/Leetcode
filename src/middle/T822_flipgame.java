package middle;

import java.util.HashSet;
import java.util.Set;

public class T822_flipgame {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; ++i) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        for (int i = 0; i < fronts.length; ++i) {
            if (fronts[i] != backs[i]) {
                if (!set.contains(fronts[i])) {
                    res = Math.min(res, fronts[i]);
                }
                if (!set.contains(backs[i])) {
                    res = Math.min(res, backs[i]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        String str = "";
        System.out.print(str.split(",").length);
    }
}
