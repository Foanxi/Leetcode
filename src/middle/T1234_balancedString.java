package middle;

/**
 * @author foanxi
 */
public class T1234_balancedString {
    int max;

    public int balancedString(String s) {
        max = s.length() / 4;
        int result = s.length();
        int[] check = new int['X'];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            check[c]++;
        }
        if (isValid(check)) {
            return 0;
        }

        // 找出右边界，此时不断向右循环直到滑动窗口外已经满足要求
        for (int left = 0, right = 0; left < s.length(); left++) {
            while (right < s.length() && !isValid(check)) {
                check[chars[right]]--;
                right++;
            }
            if (!isValid(check)) {
                break;
            }
            result = Math.min(result, right - left);
            check[chars[left]]++;
        }
        return result;
    }


    public boolean isValid(int[] check) {
        return check['Q'] <= max && check['W'] <= max && check['E'] <= max && check['R'] <= max;
    }

    public static void main(String[] args) {
        System.out.println(new T1234_balancedString().balancedString("QQQE"));
    }
}