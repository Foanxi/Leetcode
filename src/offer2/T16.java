package offer2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T16 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            while (left <= right && set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }

    public String[] getMaxString(String s) {
        Set<String> res = new HashSet<>();
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            while (left <= right && set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            right++;
            if (right - left > max) {
                max = right - left;
                res.clear();
                res.add(s.substring(left, right));
            } else if (right - left == max) {
                res.add(s.substring(left, right));
            }
        }
        return res.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T16().getMaxString("abcabcbb")));
        ;
    }
}
