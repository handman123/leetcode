package org.review._25_03;

public class Code_25_03_10_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        // 双指针
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            while (sum >= target && j <= i){
                minLen = Math.min(minLen, i - j + 1);
                sum -= nums[j++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
