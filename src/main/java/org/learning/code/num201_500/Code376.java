package org.learning.code.num201_500;

public class Code376 {

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        // 特殊条件
        if (len <= 1)
            return len;
        // 处理
        // 结果
        int res = 1;
        int preDiff = 0;
        int curDiff = 0;
        for (int i = 0; i < len - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            if (curDiff > 0 && preDiff <= 0 || curDiff <= 0 && preDiff > 0){
                preDiff = curDiff;
                res++;
            }
        }
        return res;
    }
}
