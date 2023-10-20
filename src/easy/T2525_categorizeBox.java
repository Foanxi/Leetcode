package easy;

/**
 * @author foanxi
 */
public class T2525_categorizeBox {
    public String categorizeBox(int length, int width, int height, int mass) {
        int judge = 10000;
        int judge2 = 1000000000;
        String cur = "Neither";
        if (mass >= 100) {
            cur = "Heavy";
        }
        if (length >= judge || width >= judge || height >= judge || ((long) length * width * height) >= judge2) {
            if ("Heavy".equals(cur)) {
                cur = "Both";
            } else {
                cur = "Bulky";
            }
        }
        return cur;
    }
}
