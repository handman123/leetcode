package org.review._25_03._11_20;

public class Code_12_5 {
    /**
     * dp[i][j] 表示[i...j]回文长度
     * dp[i][j] = dp[i + 1][j - 1] + 2;
     * @param s 目标字符串
     * @return  回文字符串
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        // dp数组
        int[][] dp = new int[len][len];
        // 数组填充
        int maxLen = Integer.MIN_VALUE;
        int x = 0, y = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) dp[i][j] = 1;
                else if (i + 1 == j && s.charAt(i) == s.charAt(j))
                    dp[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0)
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                if (maxLen < dp[i][j]){
                    maxLen = dp[i][j];
                    x = i; y = j;
                }
            }
        }
        return s.substring(x, y + 1);
    }
}
