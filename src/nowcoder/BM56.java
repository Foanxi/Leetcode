package nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class BM56 {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
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
            if (i > 0 && !used[i - 1] && num[i - 1] == num[i]) {
                continue;
            }
            used[i] = true;
            temp.add(num[i]);
            traversal(num, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BM56().permuteUnique(new int[]{1, 1, 2}));
    }
}
