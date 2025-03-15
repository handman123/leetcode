package org.whut.code.dpoint;

/**
 * <p>
 *     283. 移动零
 * </p>
 * <p>
 *     给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * </p>
 * <p>
 *     请注意 ，必须在不复制数组的情况下原地对数组进行操作。
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
