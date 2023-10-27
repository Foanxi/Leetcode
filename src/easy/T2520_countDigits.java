package easy;

/**
 * @author foanxi
 */
public class T2520_countDigits {
    public int countDigits(int num) {
        int res = 0;
        int judge = num;
        while (num > 0) {
            if (judge % (num % 10) == 0) {
                res++;
            }
            num /= 10;
        }
        return res;
    }
}
