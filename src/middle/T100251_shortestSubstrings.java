package middle;

import java.util.*;

public class T100251_shortestSubstrings {
    public String[] shortestSubstrings(String[] arr) {
        int length = arr.length;
        String[] res = new String[length];
        Arrays.fill(res,"");
        Set<String>[] sets = new Set[length];
        for (int i = 0; i < length; i++) {
            sets[i] = new HashSet<>();
        }
        for (int i = 0; i < length; i++) {
            String str = arr[i];
            for (int len = 1; len <= str.length(); len++) {
                for (int index = 0; index + len <= str.length(); index++) {
                    sets[i].add(str.substring(index, index + len));
                }
            }
        }
        for (int j = 0; j < length; j++) {
            List<String> list = new ArrayList<>(sets[j]);
            list.sort((o1, o2) -> {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    return o1.length() - o2.length();
                }
            });
            for (String string : list) {
                boolean flag = true;
                for (int k = 0; k < length; k++) {
                    if (k == j) {
                        continue;
                    }
                    if (sets[k].contains(string)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res[j] = string;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T100251_shortestSubstrings().shortestSubstrings(new String[]{"cab", "ad", "bad", "c"})));
    }
}
