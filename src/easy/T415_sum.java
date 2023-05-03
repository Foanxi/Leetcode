package easy;

/**
 * @author foanxi
 */
public class T415_sum {
    public static String sumBigNum(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            sb.append((n1 + n2 + carry) % 10);
            carry = (n1 + n2 + carry) / 10;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}
