package easy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author foanxi
 */
public class T2578_splitNum {

    public int splitNum(int num) {
        char[] stnum = Integer.toString(num).toCharArray();
        Arrays.sort(stnum);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < stnum.length; ++i) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + (stnum[i] - '0');
            } else {
                num2 = num2 * 10 + (stnum[i] - '0');
            }
        }
        return num1 + num2;
    }

    public int splitNum2(int num) {
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        int len = 0;
        while (num > 0) {
            queue.add(num % 10);
            num /= 10;
        }
        int res = 0;
        int next = 0;
        int cur = 1;
        while (!queue.isEmpty()) {
            int num1 = queue.poll();
            int num2 = 0;
            if (!queue.isEmpty()) {
                num2 = queue.poll();
            }

            if (num1 + num2 >= 10) {
                res = (num1 + num2 - 10 + next) * cur + res;
                next = 1;
            } else {
                res = (num1 + num2 + next) * cur + res;
                next = 0;
            }
            cur *= 10;
        }
        if (next != 0) {
            res = cur + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T2578_splitNum().splitNum(4325));
    }
}
