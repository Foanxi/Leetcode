package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class T面试题17_05 {
    public String[] findLongestSubarray(String[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int startIndex = -1;
        int sum = 0;
        int maxLength = 0;
        map.put(sum, startIndex);
        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i].charAt(0))) {
                sum++;
            } else {
                sum--;
            }
            if (map.containsKey(sum)) {
                int lastIndex = map.get(sum);
                if (i - lastIndex > maxLength) {
                    maxLength = i - lastIndex;
                    startIndex = lastIndex + 1;
                }
            } else {
                map.put(sum, i);
            }
        }
        if (maxLength == 0){
            return new String[0];
        }
        String[] res = new String[maxLength];
        System.arraycopy(array, startIndex, res, 0, res.length);
        return res;
    }
}
