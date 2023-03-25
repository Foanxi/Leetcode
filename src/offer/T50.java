package offer;

public class T50 {
    public char firstUniqChar(String s) {
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map[c - 'a']++;
        }
        for (char c:chars){
            if (map[c-'a'] == 1){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        char leetcode = new T50().firstUniqChar("leetcode");
    }
}
