package middle;

import java.util.*;

/**
 * @author foanxi
 */
public class T7006_maximizeTheProfit {

    Set<Integer> set = new HashSet<>();

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        return dfs(offers, 0);
    }

    public int dfs(List<List<Integer>> offers, int startIndex) {
        if (startIndex >= offers.size()) {
            return 0;
        }
        // 满足当前商家,检验是否能满足先
        List<Integer> cur = offers.get(startIndex);
        boolean can = true;
        for (int start = cur.get(0); start <= cur.get(1); start++) {
            if (set.contains(start)) {
                can = false;
                break;
            }
        }
        int sold = 0;
        if (can) {
            for (int start = cur.get(0); start <= cur.get(1); start++) {
                set.add(start);
            }
            sold = dfs(offers, startIndex + 1) + cur.get(2);
            for (int start = cur.get(0); start <= cur.get(1); start++) {
                set.remove(start);
            }
        }
        // 不满足当前商家
        int noSold = dfs(offers, startIndex + 1);
        // 返回最大
        return Math.max(sold, noSold);
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(0);
        temp1.add(0);
        temp1.add(1);
        list.add(temp1);
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(0);
        temp2.add(2);
        temp2.add(2);
        list.add(temp2);
        List<Integer> temp3 = new ArrayList<>();
        temp3.add(1);
        temp3.add(3);
        temp3.add(2);
        list.add(temp3);
        System.out.println(new T7006_maximizeTheProfit().maximizeTheProfit(5, list));
    }
}
