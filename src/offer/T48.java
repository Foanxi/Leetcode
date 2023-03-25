package offer;

import java.util.HashMap;
import java.util.Map;

public class T48 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int res = 0;
        int left = -1;
        for (int right = 0; right < chars.length; right++) {
            if (map.containsKey(chars[right])) {
                left = Math.max(left, map.get(chars[right]));
            }
            map.put(chars[right], right);
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T48().lengthOfLongestSubstring("abcabcbb"));
    }
}
