package middle;

public class T1616_checkPalindromeFormation {
    public boolean checkPalindromeFormation(String a, String b) {
        return findPre(a, b) || findPre(b, a);
    }

    public boolean findPre(String a, String b) {
        int left = 0;
        int right = a.length() - 1;
        while (left < right && a.charAt(left) == b.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right) {
            return true;
        }
        return isPalindrome(a, left, right) || isPalindrome(b, left, right);
    }

    /**
     * 判断字符串s[i,j]区间内是否为回文字符串
     *
     * @param s 字符串
     * @param i 左指针
     * @param j 右指针
     * @return 是否为回文字符串
     */
    public boolean isPalindrome(String s, int i, int j) {
        while (s.charAt(i) == s.charAt(j)) {
            i++;
            j--;
        }
        return i >= j;
    }
}
