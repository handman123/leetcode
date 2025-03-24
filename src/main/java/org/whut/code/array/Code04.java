package org.whut.code.array;

import java.util.Arrays;

/**
 * <p>
 *     238. 除自身以外数组的乘积
 * </p>
 * <p>
 *     给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * </p>
 * <p>
 *     题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * </p>
 * <p>
 *     请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * </p>
 */
public class Code04 {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        // 特殊返回
        if (nums.length <= 1)
            return nums;
        // 返回数组
        int[] res = new int[len];
        // 处理
        int left = 1;
        for (int i = 0; i < nums.length; i++){
            res[i] = left;
            left *= nums[i];
        }
//        System.out.println("res = " + Arrays.toString(res));
        int right = 1;
        for (int i = nums.length - 1; i >=0 ; i--) {
            res[i] *= right;
            right *= nums[i];
        }
//        System.out.println("res = " + Arrays.toString(res));
        return res;
    }
}
