package middle;

import java.util.HashSet;
import java.util.Set;

class T3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        while (right < s.length()) {
            while (set.contains(chars[right])) {
                set.remove(chars[left]);
                left++;
            }
            set.add(chars[right]);
            right++;
            max = Math.max(set.size(), max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new T3_lengthOfLongestSubstring().lengthOfLongestSubstring("bdwqdqwbb"));
    }
}