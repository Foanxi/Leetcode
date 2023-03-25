package middle;

import java.util.HashMap;
import java.util.Map;

public class T1419_minNumberOfFrogs {
    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('c',0);
        map.put('r',1);
        map.put('o',2);
        map.put('a',3);
        map.put('k',4);
        int[] count = new int[5];
        char[] chars = croakOfFrogs.toCharArray();
        int res = 0;
        for (char c: chars){
            count[map.get(c)]++;
            if (c != 'c' && count[map.get(c)] > count[map.get(c) - 1]){
                return -1;
            }
            res = Math.max(res,count[0] - count[4]);
        }
        return count[4] - count[0] == 0? res : -1;
    }
}
