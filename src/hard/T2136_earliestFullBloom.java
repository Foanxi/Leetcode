package hard;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class T2136_earliestFullBloom {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int res = 0;
        int cur = 0;
        Integer[] idx = new Integer[growTime.length];
        for (int i = 0;i<idx.length;i++){
            idx[i] = i;
        }
        Arrays.sort(idx, (o1, o2) -> {
            if (growTime[o1] == growTime[o2]){
                return plantTime[o2] - plantTime[o1];
            }else {
                return growTime[o2] - growTime[o1];
            }
        });
        for (int i : idx) {
            cur += plantTime[i];
            res = Math.max(res, cur + growTime[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        new T2136_earliestFullBloom().earliestFullBloom(new int[]{1, 4, 3}, new int[]{2, 3, 1});
    }
}
