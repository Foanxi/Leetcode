package easy;

public class T2697_makeSmallestPalindrome {
    public String makeSmallestPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (l < r) {
            if (charArray[l] != charArray[r]) {
                if (charArray[l] > charArray[r]) {
                    charArray[l] = charArray[r];
                } else {
                    charArray[r] = charArray[l];
                }
            }
            l++;
            r--;
        }
        return new String(charArray);
    }
}
