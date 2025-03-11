package _25_03;

/**
 *  dp[i][j] 表示前i个字符，分割成j份，需要修改字符数量
 *  dp[i][j] = min{dp[i][j], dp[io][j - 1] + 1}
 *  0 < io < i < k - 1 将字符串分割 [0...io] [io + 1...i]
 */

public class Code_25_03_04_1278 {

    public int palindromePartition(String s, int k) {
        int len = s.length();
        if (k == len)
            return 0;
        // 创建dp数组
        int[][] dp = new int[len + 1][k + 1];
        // 循环
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= Math.min(k, i); j++) {
                if (j == 1)
                    dp[i][j] = cost(s, 0, i - 1);
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int io = j - 1; io < i; io++) {
                        dp[i][j] = Math.min(dp[io][j - 1] + cost(s, io, i - 1), dp[i][j]);
                    }
                }
            }
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                System.out.print(" " + dp[i][j]);
            }
            System.out.println();
        }
        return dp[len][k];
    }

    private int cost(String s, int x, int y){
        int times = 0;
        while (x < y){
            if (s.charAt(x) != s.charAt(y))
                times++;
            x++;
            y--;
        }
        return times;
    }
}
