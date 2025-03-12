package org.review._25_03._11_20;

public class Code_12_42 {

    /**
     * 双指针解法，记录左侧和右侧最高指针，
     * 如果当前左（右）侧指针矮与最高指针，则新增雨水
     * 否则更新最高指针
     * @param height  柱子数组
     * @return  雨水数量
     */
    public int trap(int[] height) {
        int len = height.length;
        // 特殊输入处理
        if (len <= 2)
            return 0;
        // 双指针
        int left = 0, right = len - 1;
        int leftMax = Integer.MIN_VALUE, rightMax= Integer.MIN_VALUE;
        // 返回结果
        int res = 0;
        // 双指针遍历
        while (left <= right){
            if (height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
                left++;
            }
            else {
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
