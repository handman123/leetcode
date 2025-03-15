package org.whut.code.dpoint;

/**
 * <p>
 *     11. 盛最多水的容器
 * </p>
 * <p>
 *     给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * </p>
 * <p>
 *     找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * </p>
 * <p>
 *     返回容器可以储存的最大水量。
 * </p>
 */
public class Code02 {

    // 双指针，一个左侧，一个右侧。盛水量取决于最矮的那个，每次移动最矮的那个
    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right){
            int temp = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, temp);
            if (height[left] < height[right])
                left++;
            else right--;
        }
        return max;

    }
}
