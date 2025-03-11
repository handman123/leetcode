package _25_03;

public class Code_25_3_8_5 {

    /**
     * DP[i][j] [i,j]回文子串长度
     * dp[i][j] = dp[i + 1][j - i]
     */

    public String longestPalindrome(String s) {
        int len = s.length();

        int[][] dp = new int[len][len];

        // 填充DP
        int maxLen = Integer.MIN_VALUE;
        int x = 0, y = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) dp[i][j] = 1;
                if (i + 1 == j && s.charAt(i) == s.charAt(j))
                    dp[i][j] = 2;
                else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] != 0)
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                if (maxLen < dp[i][j]){
                    maxLen = dp[i][j];
                    x = i;
                    y = j;
                }
            }
        }

        // 返回结果
        return s.substring(x, y + 1);
    }
}
