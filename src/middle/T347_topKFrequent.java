package middle;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class T347_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((para1,para2)->para2[1]-para1[1]);
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            priorityQueue.add(new int[]{entry.getKey(),entry.getValue()});
        }
        for (int i=0;i<k;i++){
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        T347_topKFrequent t347TopKFrequent = new T347_topKFrequent();
        int[] nums = {1, 2, 3, 4, 1};
        t347TopKFrequent.topKFrequent(nums, 1);
    }
}
