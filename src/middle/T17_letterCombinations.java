package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author foanxi
 */
public class T17_letterCombinations {
    List<String> result = new ArrayList<>();
    String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backTracking(digits, 0);
        return result;
    }

    public void backTracking(String digits, int startIndex) {
        if (startIndex == digits.length()) {
            result.add(sb.toString());
            return;
        }
        int index = digits.charAt(startIndex) - '0';
        String temp = strings[index];
        for (int i = 0; i < temp.length(); i++) {
            sb.append(temp.charAt(i));
            backTracking(digits, startIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new T17_letterCombinations().letterCombinations("23"));
    }
}
