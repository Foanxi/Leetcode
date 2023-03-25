package offer2;

import java.util.Arrays;
import java.util.LinkedList;

public class T75 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1000];
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = 0; i < arr2.length; i++) {
            map[arr2[i]] = i + 1;
        }
        return Arrays.stream(arr1).boxed().sorted((o1, o2) -> {
            if (map[o1] != 0 && map[o2] != 0) {
                return map[o1] - map[o2];
            } else if (map[o1]!=0){
                return -1;
            }else if (map[o2]!=0){
                return 1;
            }else {
                return o1 - o2;
            }
        }).mapToInt(Integer::valueOf).toArray();
    }
}
