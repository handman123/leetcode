package org.learning.code.num1_100;

public class Code55 {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return true;
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1)
                return true;
        }
        return false;
    }
}
