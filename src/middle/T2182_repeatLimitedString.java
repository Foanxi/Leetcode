package middle;

import java.util.Map;
import java.util.TreeMap;

public class T2182_repeatLimitedString {

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] dict = new int[26];
        for (char c : s.toCharArray()) {
            dict[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        int m = 0;
        for (int cur = 25, next = 24; cur >= 0 && next >= 0; ) {
            if (dict[cur] == 0) {
                m = 0;
                cur--;
            } else if (m < repeatLimit) {
                dict[cur]--;
                res.append((char) ('a' + cur));
                m++;
            } else if (next >= cur || dict[next] == 0) {
                next--;
            } else {
                dict[next]--;
                res.append((char) ('a' + next));
                m = 0;
            }
        }
        return res.toString();
    }

    public String repeatLimitedString2(String s, int repeatLimit) {
        TreeMap<Character, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder res = new StringBuilder();
        while (!map.isEmpty()) {
            Map.Entry<Character, Integer> entry = map.pollFirstEntry();
            for (int i = 0; i < entry.getValue(); i++) {
                res.append(entry.getKey());
                if (i < entry.getValue() - 1 && (i + 1) % repeatLimit == 0) {
                    Map.Entry<Character, Integer> second = map.firstEntry();
                    if (second == null) {
                        break;
                    }
                    if (second.getValue() == 0) {
                        map.pollFirstEntry();
                        second = map.firstEntry();
                        if (second == null) {
                            break;
                        }
                    }
                    res.append(second.getKey());
                    map.put(second.getKey(), second.getValue() - 1);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T2182_repeatLimitedString().repeatLimitedString("bplpcfifosybmjxphbxdltxtfrjspgixoxzbpwrtkopepjxfooazjyosengdlvyfchqhqxznnhuuxhtbrojyhxwlsrklsryvmufoibgfyxgjw", 1));
    }
}
