package org.review._25_03._01_10;

public class Code_10_1278 {

    // dp[i][j] [1...i]之间分割j次需要修改多少次
    // dp[i][j] = min(dp[i][j], dp[io][j - 1] + num(io + 1, i)) io in [j - 1...i)
    // 循环方向 i 0 -> s.length


    public int palindromePartition(String s, int k) {
        int len = s.length();
        if (len == k)
            return 0;

        int[][] dp = new int[len + 1][len + 1];

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                if (j == 1)
                    dp[i][j] = cost(s, 0, i - 1);
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int io = j - 1; io < i; io++) {
                        dp[i][j] = Math.min(dp[i][j], dp[io][j - 1] + cost(s, io, i - 1));
                    }
                }
            }
        }

        return dp[len][k];
    }

    // 计算字符串start 到 end 子字符串变成回文需要修改多少次
    private int cost(String s, int start, int end){
        int nums = 0;
        while (start < end){
            if (s.charAt(start) != s.charAt(end))
                nums++;
            start++;
            end--;
        }
        return nums;
    }
}
