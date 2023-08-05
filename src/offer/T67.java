package offer;

public class T67 {
    public int strToInt(String s) {
        boolean flag = false;
        long res = 0L;
        s = s.trim();
        boolean startRead = false;
        for (char c : s.toCharArray()) {
            if (!startRead && c == '-') {
                flag = true;
                startRead = true;
                continue;
            } else if (!startRead && c == '+') {
                startRead = true;
                continue;
            }
            if (c < '0' || c > '9') {
                break;
            } else if (res * 10 + c - '0' > Integer.MAX_VALUE) {
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                startRead = true;
                res = res * 10 + c - '0';
            }
        }
        return (int) ((flag ? -1 : 1) * res);
    }

    public static void main(String[] args) {
        System.out.println(new T67().strToInt("0-1"));
    }
}
