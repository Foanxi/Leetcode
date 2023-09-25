package easy;

/**
 * @author foanxi
 */
public class LCP_06_minCount {

    public int minCount(int[] coins) {
        int res = 0;
        for (int num : coins) {
            if (num % 2 == 1) {
                res++;
                num--;
            }
            res += num / 2;
        }
        return res;
    }

}
