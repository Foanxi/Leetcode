package middle;

/**
 * @author foanxi
 */
public class T1010_numPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        long res = 0;
        int[] count = new int[60];
        for (int j : time) {
            count[j % 60]++;
        }
        for (int j = 1; j < 30; ++j) {
            res += (long) count[j] * count[60 - j];
        }
        res += (long) count[0] * (count[0] - 1) / 2 + (long) count[30] * (count[30] - 1) / 2;
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(new T1010_numPairsDivisibleBy60().numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }
}
