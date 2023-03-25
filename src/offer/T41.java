package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T41 {

    class MedianFinder {
        PriorityQueue<Integer> max;
        PriorityQueue<Integer> min;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            max = new PriorityQueue<>((o1, o2) -> o2-o1);
            min = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (max.size() == min.size()) {
                max.add(num);
                min.add(max.poll());
            } else {
                min.add(num);
                max.add(min.poll());
            }
        }

        public double findMedian() {
            return min.size() == max.size() ? min.peek() : (max.peek() + min.peek()) / 2.0;
        }
    }
}
