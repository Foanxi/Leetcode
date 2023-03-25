package easy;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class T455_findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int max = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; j++) {
            if (g[i] <= s[j]) {
                max++;
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new T455_findContentChildren().findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }
}
