package middle;

public class T2645_addMinimum {
    public int addMinimum2(String word) {
        int res = 0;
        int cur = 0;
        char[] chars = {'a', 'b', 'c'};
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (cur != word.length()) {
            if (word.charAt(cur) != chars[index % 3]) {
                res++;
            } else {
                cur++;
            }
            sb.append(chars[index % 3]);
            index++;
        }
        if (sb.charAt(sb.length() - 1) != 'c') {
            res += 3 - index % 3;
        }
        return res;
    }

    public int addMinimum(String word) {
        int n = word.length(), cnt = 1;
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) <= word.charAt(i - 1)) {
                cnt++;
            }
        }
        return cnt * 3 - n;
    }

    public static void main(String[] args) {
        System.out.println(new T2645_addMinimum().addMinimum("abc"));
    }
}
