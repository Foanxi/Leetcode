package middle;

public class T2707_minExtraChar {
    public int minExtraChar(String s, String[] dictionary) {
        int res = 0;
        boolean[] used = new boolean[s.length()];
        for (String str : dictionary) {
            for (int i = s.indexOf(str); i < str.length(); i++) {
                used[i] = true;
            }
        }
        for (boolean b : used) {
            if (!b) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T2707_minExtraChar().minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"}));
    }
}
