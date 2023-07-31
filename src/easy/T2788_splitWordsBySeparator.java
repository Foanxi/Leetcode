package easy;

import java.util.ArrayList;
import java.util.List;

public class T2788_splitWordsBySeparator {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int l = 0;
            char[] charArray = word.toCharArray();
            for (int r = 0; r < word.length(); ++r) {
                if (charArray[r] == separator) {
                    if (r - l == 0) {
                        l = r + 1;
                        continue;
                    }
                    res.add(word.substring(l, r));
                    l = r + 1;
                }
                if ((r == word.length() - 1 && r - l >= 1) || (l == word.length() - 1 && r == word.length() - 1) || (l == 0 && r == word.length() - 1)) {
                    res.add(word.substring(l, r + 1));
                }
            }
        }
        return res;
    }
}
