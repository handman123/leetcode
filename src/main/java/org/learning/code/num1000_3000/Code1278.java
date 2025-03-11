package org.learning.code.num1000_3000;

public class Code1278 {



    // dp[i][j] ：将S前i个字符串分割成j个回文字符串需要修改字符个数
    // dp[i][j] = Math.min(dp[io][j - 1] + cost(s, io + 1, i), dp[i][j])
    public int palindromePartition(String s, int k) {
        int len = s.length();
        if (k == len)
            return 0;
        // 创建dp数组
        int[][] dp = new int[len + 1][k + 1];
        // 生成dp数组
        for (int i = 1; i <= len; i++){
            for (int j = 1; j <= Math.min(i, k); j++){
                if (j == 1)
                    dp[i][j] = cost(s, 0, i - 1);
                else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int io = j - 1; io < i; io++){
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


    private int cost(String s, int i, int j){
        int num = 0;
        for (; i < j; i++, j--){
            if (s.charAt(i) != s.charAt(j))
                num++;
        }
        return num;
    }








    // 无法解决问题
//    public int palindromePartition(String s, int k) {
//        // 分割次数刚好能将s拆散单一字符
//        int len = s.length();
//        if (k == len - 1)
//            return 0;
//        // dp，dp[i][j]: i - j是否为dp数组
//        boolean[][] dp = new boolean[len][len];
//        for (int i = len - 1; i >= 0; i--) {
//            for (int j = i; j < len; j++) {
//                if (i == j) dp[i][j] = true;
//                else if (i + 1 == j && s.charAt(i) == s.charAt(j))
//                    dp[i][j] = true;
//                else if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])
//                    dp[i][j] = true;
//            }
//        }
//        // 找到大于等于k的最小序列
//        int[] dp1 = new int[len];  // dp_1[i] [0...i]之间最小分割次数
//        Arrays.fill(dp1, Integer.MAX_VALUE);
//        List<String> list = new ArrayList<>();
//        StringBuilder temp = new StringBuilder();
//        for (int i = 0; i < len; i++) {
//            if (dp[0][i]) {
//                dp1[i] = 0;
//                temp.append(s.charAt(i));
//            }
//            else {
//                // 分成：[0...j] [j+1..i]
//                for (int j = 0; j < i; j++){
//                    if (dp[j + 1][i] && dp1[i] > dp1[j] + 1){
//                        dp1[i] = dp1[j] + 1;
//                    }
//                }
//            }
//        }
//        // 刚好等于最小次数
//        if (dp1[len - 1] == k)
//            return 0;
//
//        return 0;
//    }
}
