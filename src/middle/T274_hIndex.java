package middle;

import java.util.Arrays;

/**
 * @author foanxi
 */
public class T274_hIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int index = citations.length - 1;
        while (index >= 0 && citations[index] > h) {
            index--;
            h++;
        }
        return h;
    }
}
