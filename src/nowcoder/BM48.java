package nowcoder;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author foanxi
 */
public class BM48 {

    Queue<Integer> minQueue = new PriorityQueue<>();
    Queue<Integer> maxQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));

    public void Insert(Integer num) {
        if (maxQueue.size() == minQueue.size()) {
            maxQueue.add(num);
            minQueue.add(maxQueue.poll());
        } else {
            minQueue.add(num);
            maxQueue.add(minQueue.poll());
        }
    }

    public Double GetMedian() {
        return minQueue.size() != maxQueue.size() ? (double) minQueue.peek() : (minQueue.peek() + maxQueue.peek()) / 2.0;
    }

    public static void main(String[] args) {
        BM48 bm48 = new BM48();
        bm48.Insert(5);
        System.out.println(bm48.GetMedian());
        bm48.Insert(2);
        System.out.println(bm48.GetMedian());
        bm48.Insert(3);
        System.out.println(bm48.GetMedian());
        bm48.Insert(4);
        System.out.println(bm48.GetMedian());
        bm48.Insert(1);
        System.out.println(bm48.GetMedian());
        bm48.Insert(6);
        System.out.println(bm48.GetMedian());
        bm48.Insert(7);
        System.out.println(bm48.GetMedian());
        bm48.Insert(0);
        System.out.println(bm48.GetMedian());
        bm48.Insert(8);
        System.out.println(bm48.GetMedian());
    }
}
