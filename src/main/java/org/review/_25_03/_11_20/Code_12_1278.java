package org.review._25_03._11_20;

public class Code_12_1278 {
    /**
     * dp[i][j] 将字符串[0...i]分割为j个子字符串需要最小修改次数
     * dp[i][j] = min(dp[io][j - 1] + cost(s, io + 1, i), dp[i])
     *          其中 io范围：[j - 1, i - 1]
     *          j范围：[1...min(i,k)]
     * @param s 目标字符串
     * @param k 分割段数
     * @return  修改字符串次数
     */
    public int palindromePartition(String s, int k) {
        int len = s.length();
        // dp数组
        int[][] dp = new int[len + 1][k + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                if (j == 1){
                    dp[i][j] = cost(s, 0, i - 1);
                }
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int io = j - 1; io < i; io++) {
                        dp[i][j] = Math.min(dp[i][j], dp[io][j - 1] + cost(s, io, i - 1));
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

    /**
     * 统计s字符串中，[start...end]这段子字符串变为回文需要修改字符次数。
     * @param s 目标字符串
     * @param start 开始位置
     * @param end   结束位置
     * @return  修改次数
     */
    private int cost(String s, int start, int end){
        if (start >= end)
            return 0;
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
