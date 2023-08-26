package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author foanxi
 */
public class BM58 {

    ArrayList<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public ArrayList<String> Permutation(String str) {
        if (str.isEmpty()) {
            res.add("");
            return res;
        }
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        traversal(charArray, new boolean[str.length()]);
        return res;
    }

    public void traversal(char[] str, boolean[] used) {
        if (str.length == sb.length()) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && used[i - 1] && str[i - 1] == str[i]) {
                continue;
            }
            used[i] = true;
            sb.append(str[i]);
            traversal(str, used);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}
