package middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author foanxi
 */
public class T216_combinationSum3 {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k, n, 1);
        return result;
    }

    public void backTracking(int k, int n, int startIndex) {
        if (n < 0) {
            return;
        }
        if (k == path.size()) {
            if (n == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = startIndex; i <= 9; i++) {
            path.add(i);
            backTracking(k, n - i, i + 1);
            path.removeLast();
        }
    }
}
