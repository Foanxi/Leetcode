package middle;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class T265_canMeasureWater {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        LinkedList<int[]> stack = new LinkedList<>();
        stack.add(new int[]{0, 0});
        Set<Long> set = new HashSet<>();
        while (!stack.isEmpty()) {
            // 每次有以下集中操作
            int[] poll = stack.pop();
            if (set.contains(hash(poll))) {
                continue;
            }
            set.add(hash(poll));
            if (poll[0] == targetCapacity || poll[1] == targetCapacity || poll[0] + poll[1] == targetCapacity) {
                return true;
            }
            // 将一号杯倒满
            stack.add(new int[]{jug1Capacity, poll[1]});
            // 二号杯装满
            stack.add(new int[]{poll[0], jug2Capacity});
            // 将一号倒到二号
            stack.add(new int[]{poll[0] - Math.min(poll[0], jug2Capacity - poll[0]), poll[1] + Math.min(poll[0], jug2Capacity - poll[1])});
            // 将二号倒到一号
            stack.add(new int[]{poll[0] + Math.min(poll[1], jug1Capacity - poll[0]), poll[1] - Math.min(poll[1], jug1Capacity - poll[0])});
            // 把一号水倒掉
            stack.add(new int[]{0, poll[1]});
            // 把二号水倒掉
            stack.add(new int[]{poll[0], 0});
        }
        return false;
    }

    public long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }
}
