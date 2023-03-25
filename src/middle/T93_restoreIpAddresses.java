package middle;

import java.util.ArrayList;
import java.util.List;

public class T93_restoreIpAddresses {
    List<String> result = new ArrayList<>();
    StringBuilder temp = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return result;
        }
        backTracking(s, 0, 0);
        return result;
    }

    public void backTracking(String s, int pointNum, int startIndex) {
        if (pointNum == 3) {
            if (isValid(s, startIndex, s.length() - 1)) {
                temp.append(s, startIndex, s.length());
                result.add(temp.toString());
                temp.delete(temp.length() - (s.length() - startIndex), temp.length());
            }
            return;
        }

        for (int i = startIndex; i < s.length() && pointNum <= 3; i++) {
            if (isValid(s, startIndex, i)) {
                temp.append(s, startIndex, i + 1).append(".");
                backTracking(s, pointNum + 1, i + 1);
                temp.delete(temp.length() - (i + 1 - startIndex) - 1, temp.length());
            } else {
                break;
            }
        }
    }

    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}
