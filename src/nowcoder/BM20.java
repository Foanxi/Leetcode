package nowcoder;

/**
 * @author foanxi
 */
public class BM20 {
    public int InversePairs(int[] array) {
        int res = 0;
        for (int i = array.length - 1; i >= 0; --i) {
            for (int j = i - 1; j >= 0; --j) {
                if (array[j] > array[i]) {
                    res++;
                }
            }
        }
        return res;
    }
}
