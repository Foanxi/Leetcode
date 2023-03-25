package middle;

import java.util.Arrays;

public class T738_monotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        String num = String.valueOf(n);
        char[] chars = num.toCharArray();
        int startIndex = chars.length;
        for (int i=chars.length-1;i>=1;i--){
            if (chars[i-1]>chars[i]){
                chars[i-1]--;
                startIndex = i;
            }
        }

        for (int i = startIndex;i<chars.length;i++){
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    public static void main(String[] args) {
        System.out.println(new T738_monotoneIncreasingDigits().monotoneIncreasingDigits(100));
    }
}
