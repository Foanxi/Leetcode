package easy;

/**
 * @author foanxi
 */
public class T8048_maximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        int num1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                num1++;
            }
        }
        int num0 = s.length() - num1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num1 - 1; i++) {
            sb.append('1');
        }
        for (int j = 0; j < num0; j++) {
            sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }
}
