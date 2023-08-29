package offer2;

/**
 * @author foanxi
 */
public class T2 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        int lastA = a.length() - 1;
        int lastB = b.length() - 1;

        int next = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 && j >= 0; i--, j--) {
            if (charA[i] == '0' && charB[j] == '0') {
                sb.append(next);
                next = 0;
            } else if (charA[i] == '1' && charB[j] == '1') {
                sb.append(next);
                next = 1;
            } else {
                if (next == 1) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
            }
            lastA--;
            lastB--;
        }

        for (int i = lastA; i >= 0; i--) {
            if (charA[i] == '1' && next == 1) {
                sb.append(0);
            } else {
                sb.append(charA[i] - '0' | next);
                next = 0;
            }
        }
        for (int i = lastB; i >= 0; i--) {
            if (charB[i] == '1' && next == 1) {
                sb.append(0);
            } else {
                sb.append(charB[i] - '0' | next);
                next = 0;
            }
        }
        if (next == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new T2().addBinary("100", "110010"));
    }
}
