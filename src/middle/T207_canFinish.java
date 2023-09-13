package middle;

import java.util.*;

public class T207_canFinish {

    Map<Integer, Boolean> success = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> list;
            if (map.containsKey(prerequisite[0])) {
                list = map.get(prerequisite[0]);
            } else {
                list = new ArrayList<>();
            }
            list.add(prerequisite[1]);
            map.put(prerequisite[0], list);
        }
        for (int[] prerequisite : prerequisites) {
            if (!isFinish(prerequisite[0], new HashSet<>(), map)) {
                return false;
            }
            success.put(prerequisite[0], true);
        }
        return true;
    }

    public boolean isFinish(int cur, Set<Integer> visited, Map<Integer, List<Integer>> map) {
        if (success.containsKey(cur)) {
            return true;
        }
        if (!map.containsKey(cur)) {
            return true;
        } else if (visited.contains(cur)) {
            return false;
        }
        List<Integer> list = map.get(cur);
        for (Integer integer : list) {
            visited.add(cur);
            if (!isFinish(integer, visited, map)) {
                return false;
            }
            visited.remove(cur);
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] course = {{5, 5}};
        System.out.println(new T207_canFinish().canFinish(1, course));
    }
}
