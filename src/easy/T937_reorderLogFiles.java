package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T937_reorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<String> l1 = new ArrayList<>();  // 存放字母日志
        List<String> l2 = new ArrayList<>();  // 存放数字日志

        for (String log : logs) {
            char c = log.charAt(log.length() - 1);
            boolean isNum = Character.isDigit(c);  // 判断每条log最后一个字符是否为数字
            if (!isNum) {
                l1.add(log);
            } else {
                l2.add(log);
            }
        }
        // 对字母日志排序：
        Collections.sort(l1, (o1, o2) -> {
            String s1 = o1.substring(o1.indexOf(' '));
            String s2 = o2.substring(o2.indexOf(' '));
            if (s1.equals(s2)) {  // 如果标识符相同，内容不同时，忽略标识符后，按内容字母顺序排序
                return o1.compareTo(o2);
            } else {  // 否则，按标识符排序
                return s1.compareTo(s2);
            }
        });
        l1.addAll(l2);  // 把数字日志的所有元素添加到l1
        return l1.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] log = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] strings = new T937_reorderLogFiles().reorderLogFiles(log);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
