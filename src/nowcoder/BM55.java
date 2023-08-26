package nowcoder;

import java.util.ArrayList;

public class BM55 {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        traversal(num, new boolean[num.length]);
        return res;
    }

    ArrayList<Integer> temp = new ArrayList<>();

    public void traversal(int[] num, boolean[] used) {
        if (temp.size() == num.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            temp.add(num[i]);
            traversal(num, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
