package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author hujinxu
 * @date 2023/7/24
 * @description
 */
public class T771_numJewelsInStones {
    public int numJewelsInStones2(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (Character c : jewels.toCharArray()) {
            set.add(c);
        }
        int res = 0;
        for (Character c : stones.toCharArray()) {
            if (set.contains(c)) {
                res++;
            }
        }
        return res;
    }

    public int numJewelsInStones(String jewels, String stones) {
        int[] map = new int[58];
        for (Character c : jewels.toCharArray()) {
            map[c - 'A']++;
        }
        int res = 0;
        for (Character c : stones.toCharArray()) {
            if (map[c - 'A'] != 0) {
                res++;
            }
        }
        return res;
    }
}
