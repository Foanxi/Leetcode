package middle;

import java.util.ArrayList;
import java.util.List;

public class T139_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i]为true表示可以字符串0-i之间可以拆分为一个或多个字典中出现的单词
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Lee");
        strings.add("code");
        System.out.println(new T139_wordBreak().wordBreak("Leetcode", strings));
    }
}
