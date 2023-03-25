package easy;

public class T125_isPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                sb.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c + 32));
            }
        }
        char[] array = sb.toString().toCharArray();
        for (int left = 0, right = array.length - 1; left <= right; left++, right--) {
            if (array[left] != array[right]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new T125_isPalindrome().isPalindrome("0P"));
    }
}
