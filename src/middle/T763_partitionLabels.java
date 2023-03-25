package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T763_partitionLabels {
    /**
     * 使用hashmap方法
     *
     * @param s 需要分割的字符串
     * @return 返回每个分割的长度
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(chars[i], i);
        }
        int rightPos = 0;
        int leftPos = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = map.get(chars[i]);
            if (cur > rightPos) {
                rightPos = cur;
            }
            if (i == rightPos) {
                result.add(rightPos - leftPos + 1);
                leftPos = i + 1;
            }
        }
        return result;
    }

    /**
     * 使用数组快速查找方法
     *
     * @param s 需要分割的字符串
     * @return 返回每个分割的长度
     */
    public List<Integer> partitionLabels2(String s) {
        List<Integer> result = new ArrayList<>();
        int[] dir = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            dir[chars[i]-'a'] = i;
        }
        int rightPos = 0;
        int leftPos = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = dir[chars[i]-'a'];
            if (cur > rightPos) {
                rightPos = cur;
            }
            if (i == rightPos) {
                result.add(rightPos - leftPos + 1);
                leftPos = i + 1;
            }
        }
        return result;
    }
}
