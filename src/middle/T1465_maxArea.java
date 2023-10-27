package middle;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class T1465_maxArea {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        final int mod = 1_000_000_000 + 7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxLen = horizontalCuts[0];
        int maxWidth = verticalCuts[0];
        for (int i = 0; i < horizontalCuts.length - 1; ++i) {
            maxLen = Math.max(horizontalCuts[i + 1] - horizontalCuts[i], maxLen);
        }
        for (int i = 0; i < verticalCuts.length - 1; ++i) {
            maxWidth = Math.max(verticalCuts[i + 1] - verticalCuts[i], maxWidth);
        }
        maxLen = Math.max(h - horizontalCuts[horizontalCuts.length - 1], maxLen);
        maxWidth = Math.max(w - verticalCuts[verticalCuts.length - 1], maxWidth);
        return (int) (((long) maxLen * maxWidth) % mod);
    }
}
