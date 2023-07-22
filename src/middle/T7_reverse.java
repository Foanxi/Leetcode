package middle;

/**
 * @author hujinxu
 */
public class T7_reverse {
    public int reverse(int x) {
        boolean flag = x > 0;
        x = Math.abs(x);
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) (res * (flag ? 1 : -1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new T7_reverse().reverse(-2147483648));
    }
}
