package offer;

public class T46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int pre = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            int next;
            if (s.substring(i - 1, i + 1).compareTo("10") > 0 && s.substring(i - 1, i + 1).compareTo("25") <= 0) {
                next = pre + cur;
            } else {
                next = cur;
            }
            pre = cur;
            cur = next;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new T46().translateNum(12258));
    }

}
