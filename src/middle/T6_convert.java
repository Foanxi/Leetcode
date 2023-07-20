package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hujinxu
 * @date 2023/7/19
 * @description
 */
public class T6_convert {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            list.add(new StringBuilder());
        }
        // 一开始表示从上往下，false表示从下往上
        boolean flag = true;
        int rowIndex = 0;
        for (char c : s.toCharArray()) {
            list.get(rowIndex).append(c);
            if ((flag && rowIndex + 1 >= numRows) || (!flag && rowIndex - 1 < 0)) {
                flag = !flag;
            }
            rowIndex = flag ? rowIndex + 1 : rowIndex - 1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            res.append(stringBuilder);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T6_convert().convert("AB", 1));

    }
}
