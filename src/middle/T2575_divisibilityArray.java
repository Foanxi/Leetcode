package middle;

public class T2575_divisibilityArray {
    public int[] divisibilityArray(String word, int m) {
        int[] res = new int[word.length()];
        char[] charArray = word.toCharArray();
        long now = 0;
        for (int i = 0; i < word.length(); i++) {
            now = (now * 10 + charArray[i] - '0') % m;
            if (now == 0) {
                res[i] = 1;
            }
        }
        return res;
    }
}
