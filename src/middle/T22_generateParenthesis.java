package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author foanxi
 */
public class T22_generateParenthesis {

    List<String> res = new ArrayList<>();

    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        traversal(n, n);
        return res;
    }

    public void traversal(int left, int right) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left > 0) {
            sb.append("(");
            traversal(left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(")");
            traversal(left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
