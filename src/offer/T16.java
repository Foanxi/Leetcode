package offer;

/**
 * @author foanxi
 */
public class T16 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 0.0;
        }
        // 防止溢出
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T16().myPow(2.0, 9));
    }
}
