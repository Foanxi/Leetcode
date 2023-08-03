package middle;

import java.util.ArrayList;
import java.util.List;

public class T722_removeComments {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (String s : source) {
            char[] charArray = s.toCharArray();
            for (int j = 0; j < charArray.length; ++j) {

                if (!flag && j < charArray.length - 1 && charArray[j] == '/' && charArray[j + 1] == '*') {
                    flag = true;
                    j += 2;
                }
                if (!flag && j < charArray.length - 1 && charArray[j] == '/' && charArray[j + 1] == '/') {
                    break;
                }
                if (flag && j < charArray.length - 1 && charArray[j] == '*' && charArray[j + 1] == '/') {
                    flag = false;
                    j += 2;
                }
                if (!flag && j < charArray.length) {
                    sb.append(charArray[j]);
                }
            }
            if (!flag && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String[] strings = {"a/*comment", "line", "more_comment*/b"};
        System.out.println(new T722_removeComments().removeComments(strings));
    }
}
