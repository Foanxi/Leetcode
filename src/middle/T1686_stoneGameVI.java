package middle;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class T1686_stoneGameVI {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int[][] map = new int[aliceValues.length][2];
        int alice = 0;
        int bob = 0;
        for (int i = 0; i < aliceValues.length; i++) {
            map[i][0] = aliceValues[i] + bobValues[i];
            map[i][1] = i;
        }
        Arrays.sort(map, (o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < map.length; i++) {
            int cur = map[i][1];
            if (i % 2 == 0) {
                alice += aliceValues[cur];
            } else {
                bob += bobValues[cur];
            }
        }
        return Integer.compare(alice, bob);
    }

    public int stoneGameVI2(int[] aliceValues, int[] bobValues) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int alice = 0;
        int bob = 0;
        for (int i = 0; i < aliceValues.length; i++) {
            queue.add(new int[]{aliceValues[i] + bobValues[i], i});
        }
        while (!queue.isEmpty()) {
            alice += aliceValues[queue.poll()[1]];
            if (!queue.isEmpty()) {
                bob += bobValues[queue.poll()[1]];
            }
        }
        return Integer.compare(alice, bob);
    }
}
