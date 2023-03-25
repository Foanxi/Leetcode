package middle;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author foanxi
 */
public class T1647_minDeletions {
    public int minDeletions(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        Arrays.sort(chars);
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : count) {
            while (num != 0 && set.contains(num)) {
                num--;
                res++;
            }
            set.add(num);
        }
        return res;
    }
}
