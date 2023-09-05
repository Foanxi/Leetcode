package middle;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class T1921_eliminateMaximum {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] killTime = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            killTime[i] = dist[i] / speed[i];
        }
        int res = 0;
        Arrays.sort(killTime);
        for (int i = 0; i < dist.length; i++) {
            if (killTime[i] < i) {
                break;
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T1921_eliminateMaximum().eliminateMaximum(new int[]{1, 3, 4}, new int[]{1, 1, 1}));
    }
}
