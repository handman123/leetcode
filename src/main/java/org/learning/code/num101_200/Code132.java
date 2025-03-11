package org.learning.code.num101_200;

public class Code132 {
    // 不能用动态规划＋回溯法解决
    // 换dp数组
    // dp[i] 表示[0, i]最小划分次数
    // dp[i] = dp[]


    // 问题：时间复杂度过高
    private int minTimes;

    public int minCut(String s) {
        // 边界处理
        int len = s.length();
        if(len <= 1)
            return len;
        // dp数组
        int[][] dp = new int[len][len];
        // 初始化
        for(int i = 0; i < len; i++)
            dp[i][i] = 1;
        char[] c = s.toCharArray();
        minTimes = Integer.MAX_VALUE;
        // 循环
        for(int i = len - 1; i >= 0; i--){
            for(int j = i + 1; j < len; j++){
                if(c[i] == c[j] && i + 1 == j)
                    dp[i][j] = 2;
                else if(c[i] == c[j] && dp[i + 1][j - 1] != 0)
                    dp[i][j] = dp[i + 1][j - 1] + 2;
            }
        }
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }
        dfs(s, dp, 0, 0);
        return minTimes;
    }

    // times: 分割次数
    private void dfs(String s, int[][] dp, int start, int times){
        if(times > minTimes){   // 剪枝
            return;
        }
        if (start == s.length()){ // 返回
            minTimes = times - 1;
            return;
        }
        for (int i = s.length() - 1; i >= start; i--){
            if (dp[start][i] != 0){
                times++;
                dfs(s, dp, i + 1, times);
                times--;
            }
        }
    }
}
