package easy;

import java.util.List;

/**
 * @author foanxi
 */
public class T7004_isAcronym {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();
        for (String str : words) {
            sb.append(str.charAt(0));
        }
        return sb.toString().equals(s);
    }
}
