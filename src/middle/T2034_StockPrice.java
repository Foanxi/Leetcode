package middle;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author foanxi
 */
public class T2034_StockPrice {
    Map<Integer, Stock> map;

    Queue<Stock> minQueue;

    Queue<Stock> maxQueue;

    int current;

    public T2034_StockPrice() {
        map = new HashMap<>();
        minQueue = new PriorityQueue<>((o1, o2) -> o1.price - o2.price);
        maxQueue = new PriorityQueue<>(((o1, o2) -> o2.price - o1.price));
        current = 0;
    }

    public void update(int timestamp, int price) {
        Stock stock = new Stock(timestamp, price);
        map.put(timestamp, stock);
        minQueue.add(stock);
        maxQueue.add(stock);
        if (timestamp > current) {
            current = timestamp;
        }
    }

    public int current() {
        return map.get(current).price;
    }

    public int maximum() {
        while (true) {
            Stock peek = maxQueue.peek();
            if (map.get(peek.timeStamp).price == peek.price) {
                return peek.price;
            }
            maxQueue.poll();
        }
    }

    public int minimum() {
        while (true) {
            Stock peek = minQueue.peek();
            if (map.get(peek.timeStamp).price == peek.price) {
                return peek.price;
            }
            minQueue.poll();
        }
    }

    class Stock {
        private int timeStamp;

        private int price;

        public Stock(int timeStamp, int price) {
            this.timeStamp = timeStamp;
            this.price = price;
        }

        public int getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(int timeStamp) {
            this.timeStamp = timeStamp;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}
