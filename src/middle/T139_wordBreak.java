package middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author foanxi
 */
public class T139_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp[i]为true表示可以字符串0-i之间可以拆分为一个或多个字典中出现的单词
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            // 循环遍历[i,j]范围内的拼接
            // 第一轮遍历左端点，第二轮遍历右端点
            // 如果左部分[0,i]已经可以存在于字典中，循环判断从左端点到右端点[i,j]是否存在于字典中，如果可以则意味着[0,j]部分存在于字典中
            for (int j = i - 1; j < n; j++) {
                if (dp[i - 1] && wordDict.contains(s.substring(i - 1, j + 1))) {
                    dp[j + 1] = true;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("aaaa");
        strings.add("aaa");
        System.out.println(new T139_wordBreak().wordBreak("aaaaaaa", strings));
    }
}
