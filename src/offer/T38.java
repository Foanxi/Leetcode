package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T38 {

    List<String> list = new ArrayList<>();

    public String[] permutation(String s) {
        if (s.isEmpty()) {
            return null;
        }
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        dfs(charArray, new StringBuilder(), new boolean[s.length()]);
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void dfs(char[] s, StringBuilder sb, boolean[] used) {
        if (sb.length() == s.length) {
            list.add(sb.toString());
            return;
        }

        for (int i = 0; i < s.length; ++i) {
            if (i > 0 && s[i] == s[i - 1] && used[i - 1]) {
                continue;
            }
            if (used[i]) {
                continue;
            }
            used[i] = true;
            sb.append(s[i]);
            dfs(s, sb, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new T38().permutation("aac")));
    }
}
