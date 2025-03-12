package org.learning.code.num1_100;

public class Code53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len < 1)
            return 0;
        // 双循环
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < len; ) {
            sum += nums[i];
            res = Math.max(res, sum);
            if (sum <= 0){
                sum = 0;
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
}
