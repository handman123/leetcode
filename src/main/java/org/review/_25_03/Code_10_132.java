package org.review._25_03;

public class Code_10_132 {

    public int minCut(String s) {
        int len = s.length();

        boolean[][] isR = new boolean[len][len];    // (i, j) 是否为回文子串
        for (int i = len - 1; i >=0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) isR[i][j] = true;
                else if (i + 1 == j && s.charAt(i) == s.charAt(j))
                    isR[i][j] = true;
                else if (s.charAt(i) == s.charAt(j) && isR[i + 1][j - 1])
                    isR[i][j] = true;
            }
        }

        int[] dp = new int[len];    // [0...i]之间最少分割次数
        for (int i = 0; i < len; i++){
            if (isR[0][i])
                dp[i] = 0;
            else {
                // 拆分 [0...io] (io...i]
                dp[i] = Integer.MAX_VALUE;
                for (int io = 0; io < i; io++) {
                    if (isR[io + 1][i])
                        dp[i] = Math.min(dp[i], dp[io] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}
