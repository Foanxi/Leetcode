package hard;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author foanxi
 */
public class T460_LFUCache {
    class LFUCache {
        int capacity;

        TreeSet<Node> set;

        Map<Integer, Node> map;

        int time;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            set = new TreeSet<>();
            map = new HashMap<>(capacity);
            time = 0;
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            if (map.containsKey(key)) {
                Node node = map.get(key);
                set.remove(node);
                node.time = ++time;
                node.count++;
                set.add(node);
                map.put(key, node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (map.containsKey(key)) {
                Node node = map.get(key);
                set.remove(node);
                node.time = ++time;
                node.count++;
                node.val = value;
                set.add(node);
                map.put(key, node);
            } else {
                if (capacity == map.size()) {
                    Node first = set.first();
                    map.remove(first.key);
                    set.remove(first);
                }
                Node node = new Node(key, value, 0, ++time);
                map.put(key, node);
                set.add(node);
            }
        }
    }

    class Node implements Comparable<Node> {
        int key;

        int val;

        int count;

        int time;

        public Node(int key, int val, int count, int time) {
            this.key = key;
            this.val = val;
            this.count = count;
            this.time = time;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public int hashCode() {
            return count * 1000000007 + time;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            } else if (obj instanceof Node) {
                Node r = (Node) obj;
                return this.count == r.count && this.time == r.time;
            }
            return false;
        }

        @Override
        public int compareTo(Node o) {
            return this.count == o.count ? this.time - o.time : this.count - o.count;
        }
    }
}
