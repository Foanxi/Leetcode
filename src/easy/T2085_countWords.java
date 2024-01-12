package easy;

import java.util.*;

public class T2085_countWords {
    public int countWords2(String[] words1, String[] words2) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String str : words1) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int res = 0;
        for (String str : words2) {
            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }
        for (String w : map.keySet()) {
            if (map2.getOrDefault(w, 0) == 1 && map.get(w) == 1) {
                res++;
            }
        }
        return res;
    }
}
