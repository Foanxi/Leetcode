package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author foanxi
 */
public class T77_combine {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return result;
    }

    public void backTracking(int n, int k, int startIndex) {
        if (k == path.size()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new T77_combine().combine(2, 1));
    }
}
