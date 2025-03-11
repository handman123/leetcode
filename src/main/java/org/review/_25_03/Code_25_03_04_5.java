package org.review._25_03;

public class Code_25_03_04_5 {
    /**
     * dp[i][j] [i..j]之间回文子串长度
     * 在生成的过程中记录最长字串，然后输出
     */

    public String longestPalindrome(String s) {
        // 边界处理
        int len = s.length();
        if(len <= 1)
            return s;
        // dp数组
        int[][] dp = new int[len][len];
        // 生成
        int MaxNums = 0;
        int x = 0, y = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) dp[i][j] = 1;
                else if (i + 1 == j && s.charAt(i) == s.charAt(j))
                    dp[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0)
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                if (MaxNums < dp[i][j]){
                    MaxNums = dp[i][j];
                    x = i; y = j;
                }
            }
        }
        return s.substring(x, y + 1);
    }
}
