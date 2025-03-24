package org.whut.code.array;

import org.whut.Main;

/**
 * <p>
 *     53. 最大子数组和
 * </p>
 * <p>
 *     给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * </p>
 * <p>
 *     子数组是数组中的一个连续部分。
 * </p>
 */
public class Code01 {
//
//    /**
//     * 贪心
//     *
//     * @param nums  输入数组
//     * @return  最大子数组长度
//     */
//    public int maxSubArray(int[] nums) {
//
//        int max_sum = Integer.MIN_VALUE;
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            max_sum = Math.max(max_sum, sum);
//            if (sum <= 0)
//                sum = 0;
//        }
//        return max_sum == Integer.MIN_VALUE ? 0 : max_sum;
//    }

    /**
     * 动态规划：dp[i] = Math.max(dp[i - 1] + nums[i], nums[i])
     *
     * @param nums  输入数组
     * @return  最大子数组长度
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) dp[i] = nums[i];
            else dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max_sum = Math.max(max_sum, dp[i]);
        }
        return max_sum == Integer.MIN_VALUE ? 0 : max_sum;
    }
}
