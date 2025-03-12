package org.review._25_03._01_10;

public class Code_04_132 {

    /**
     * dp[i] 表示 [0, i]之间最少分割次数
     * dp[i] = min{dp[j] + 1}
     * 现在需要判断 j + 1 到 i是否为回文
     *
     * dp[i][j] 表示 [i, j]之间是否为回文
     */

    public int minCut(String s) {
        // 特殊处理
        int len = s.length();
        if (len < 1)
            return len;
        // isPal 是否为回文
        boolean[][] isPal = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) isPal[i][j] = true;
                else if (i + 1 == j && s.charAt(i) == s.charAt(j))
                    isPal[i][j] = true;
                else if (s.charAt(i) == s.charAt(j) && isPal[i + 1][j - 1])
                    isPal[i][j] = true;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(" " + isPal[i][j]);
            }
            System.out.println();
        }
        // dp[i] 表示 [0, i]之间最少分割次数
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (isPal[0][i])
                dp[i] = 0;
            else {
                // 拆分为两段，[o...j] [j + 1, i]
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (isPal[j + 1][i])
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}
