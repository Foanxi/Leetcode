package easy;

import java.util.HashSet;
import java.util.Set;

public class T2744_maximumNumberOfStringPairs {
    public int maximumNumberOfStringPairs(String[] words) {
        Set<String> set = new HashSet<>();
        int res = 0;
        for (String str : words) {
            if (set.contains(str)) {
                res++;
            } else {
                char[] charArray = str.toCharArray();
                char c = charArray[0];
                charArray[0] = charArray[1];
                charArray[1] = c;
                set.add(new String(charArray));
            }
        }
        return res;
    }
}
