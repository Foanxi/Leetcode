package offer;

import java.util.*;

public class T59_2 {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }

    static class MaxQueue {

        Queue<Integer> queue;
        Deque<Integer> maxQueue;

        public MaxQueue() {
            queue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }

        public int max_value() {
            return maxQueue.isEmpty() ? -1 : maxQueue.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!maxQueue.isEmpty() && maxQueue.peek() < value) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int pop = queue.poll();
            if (pop == maxQueue.peekFirst()) {
                maxQueue.pollFirst();
            }
            return pop;
        }
    }
}
