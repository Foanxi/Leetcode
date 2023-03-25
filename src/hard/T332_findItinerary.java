package hard;

import java.util.*;

/**
 * @author foanxi
 */
public class T332_findItinerary {
    LinkedList<String> result = new LinkedList<>();
    Map<String, Map<String, Integer>> info = new HashMap<>();

    /**
     * 使用map集合的方式检查是否已经使用过某张机票
     *
     * @param tickets 机票集合
     * @return 返回最短的机票行程安排
     */
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> list : tickets) {
            Map<String, Integer> temp;
            if (info.containsKey(list.get(0))) {
                temp = info.get(list.get(0));
                temp.put(list.get(1), temp.getOrDefault(list.get(1), 0) + 1);
            } else {
                temp = new TreeMap<>();
                // 放入终点
                temp.put(list.get(1), 1);
            }
            info.put(list.get(0), temp);
        }
        result.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(result);
    }

    public boolean backTracking(int ticketNum) {
        if (ticketNum + 1 == result.size()) {
            return true;
        }
        String last = result.getLast();
        if (info.containsKey(last)) {
            for (Map.Entry<String, Integer> target : info.get(last).entrySet()) {
                int rest = target.getValue();
                if (rest > 0) {
                    result.add(target.getKey());
                    target.setValue(rest - 1);
                    if (backTracking(ticketNum)) {
                        return true;
                    }
                    target.setValue(rest);
                    result.removeLast();
                }
            }
        }
        return false;
    }

    /**
     * 使用used数组进行检查
     *
     * @param tickets 机票集合
     * @return 返回最短的机票行程安排
     */
    public List<String> findItinerary2(List<List<String>> tickets) {
        tickets.sort(Comparator.comparing(a -> a.get(1)));
        boolean[] used = new boolean[tickets.size()];
        result.add("JFK");
        backTracking2(tickets, used);
        return new ArrayList<>(result);
    }

    List<String> finalResult;

    public boolean backTracking2(List<List<String>> tickets, boolean[] used) {
        if (tickets.size() + 1 == result.size()) {
            finalResult = new ArrayList<>(result);
            return true;
        }

        for (int i = 0; i < tickets.size(); i++) {
            if (!used[i] && tickets.get(i).get(0).equals(result.getLast())) {
                result.add(tickets.get(i).get(1));
                used[i] = true;
                if (backTracking2(tickets, used)) {
                    return true;
                }
                used[i] = false;
                result.removeLast();
            }
        }
        return false;
    }
}


