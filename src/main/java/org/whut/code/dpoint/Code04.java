package org.whut.code.dpoint;

/**
 * <p>
 *     42. 接雨水
 * </p>
 * <p>
 *     给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * </p>
 */
public class Code04 {

    // 双指针
    public int trap(int[] height) {
        if (height.length <= 2)
            return 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int left = 0, right = height.length - 1;
        int sum = 0;
        while (left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] < height[right]){
                sum += leftMax - height[left];
                left++;
            }
            else {
                sum += rightMax - height[right];
                right--;
            }

        }
        return sum;
    }
}
