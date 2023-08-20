package middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author foanxi
 */
public class T833_findReplaceString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, String[]> map = new HashMap<>();
        for (int i = 0; i < indices.length; ++i) {
            map.put(indices[i], new String[]{sources[i], targets[i]});
        }
        StringBuilder sb = new StringBuilder();
        char[] origin = s.toCharArray();
        for (int i = 0; i < origin.length; ++i) {
            if (map.containsKey(i)) {
                String source = map.get(i)[0];
                if (i + source.length() <= origin.length && s.startsWith(source, i)) {
                    sb.append(map.get(i)[1]);
                    i += source.length() - 1;
                    continue;
                }
            }
            sb.append(origin[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "vmokgggqzp";
        int[] indexes = {3, 5, 1};
        String[] sources = {"kg", "ggq", "mo"};
        String[] targets = {"s", "so", "bfr"};
        System.out.println(new T833_findReplaceString().findReplaceString(str, indexes, sources, targets));
    }
}
