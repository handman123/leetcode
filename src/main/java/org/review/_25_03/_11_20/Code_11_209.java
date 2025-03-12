package org.review._25_03._11_20;

import java.util.Arrays;

public class Code_11_209 {
    public int minSubArrayLen(int target, int[] nums) {

        int len = nums.length;

        // 排序
        Arrays.sort(nums);

        // 双指针
        int start = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            while (sum > target && start <= i){
                minLen = Math.min(minLen, i - start + 1);
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
