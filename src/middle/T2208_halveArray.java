package middle;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author hujinxu
 */
public class T2208_halveArray {

    public int halveArray(int[] nums) {
        double sum = 0;
        Queue<Double> queue = new PriorityQueue<>(((o1, o2) -> o2.compareTo(o1)));
        for (int num : nums) {
            sum += num;
            queue.add((double) num);
        }
        double need = sum / 2;
        int res = 0;
        while (sum >= need) {
            double poll = queue.poll() / 2;
            queue.add(poll);
            sum -= poll;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[100000];
        Arrays.fill(nums, 1);
        System.out.println(new T2208_halveArray().halveArray(nums));
    }

}
