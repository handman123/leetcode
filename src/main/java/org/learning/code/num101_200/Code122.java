package org.learning.code.num101_200;

public class Code122 {
    // 只收集每一天的利润
    public int maxProfit(int[] prices) {

        int len = prices.length;

        int res = 0;

        for (int i = 1; i < len; i++) {
            res += Math.max(0, prices[i] - prices[i - 1]);
        }
        return res;
    }
}
