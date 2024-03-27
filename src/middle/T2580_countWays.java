package middle;

import java.util.Arrays;

public class T2580_countWays {
    public int countWays(int[][] ranges) {
        int mod = 100_000_007;
        Arrays.sort(ranges, (o1, o2) -> o1[0] - o2[0]);
        int diff = 1;
        int right = ranges[0][1];
        for (int i = 1; i < ranges.length; i++) {
            if (ranges[i][0] < right) {
                right = Math.max(right, ranges[i][1]);
            } else {
                right = ranges[i][1];
                diff++;
            }
        }
        if (diff == 1) {
            return 2;
        }
        long res = 1;
        while (diff-- > 1) {
            res = res * 2 % mod;
        }
        return (int) res;
    }
}
