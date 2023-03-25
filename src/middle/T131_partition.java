package middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author foanxi
 */
public class T131_partition {
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return result;
    }

    public void backTracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backTracking(s, 1 + i);
            path.removeLast();
        }
    }

    public boolean isPalindrome(String s, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
