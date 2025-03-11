package org.review._25_03;

public class Code_25_03_10_1745 {
    public boolean checkPartitioning(String s) {
        int len = s.length();

        boolean[][] dp = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--){
            for (int j = i; j < len; j++) {
                if (i == j) dp[i][j] = true;
                else if (i + 1 == j && s.charAt(i) == s.charAt(j))
                    dp[i][j] = true;
                else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])
                    dp[i][j] = true;
            }
        }

        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                if (dp[0][i] && dp[i + 1][j] && dp[j +1][len - 1])
                    return true;
            }
        }
        return false;
    }
}
