package middle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author foanxi
 */
public class T146_LRUCache {

    class LRUCache {

        int capacity;

        LinkedList<Node> queue;

        Map<Integer, Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            queue = new LinkedList<>();
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            queue.remove(node);
            queue.addFirst(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                queue.remove(node);
                node.value = value;
                map.put(key, node);
                queue.addFirst(node);
                return;
            }
            if (queue.size() >= capacity) {
                Node node = queue.removeLast();
                map.remove(node.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            queue.addFirst(node);
        }

    }

    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
//        T146_LRUCache lruCache = new T146_LRUCache(2);
//        lruCache.get(2);
//        lruCache.put(2, 6);
//        lruCache.get(1);
//        lruCache.put(1, 5);
//        lruCache.put(1, 2);
//        lruCache.get(1);
//        lruCache.get(2);
    }
}
