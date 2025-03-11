public class Code42 {

    /**
     * 双指针法
     */
    public int trap(int[] height) {
        // 1. 找到第一个左侧边界（做边界height[i]大于height[i + 1]
        // 2. 双指针，找到右边界（右边界height[j]大于等于height[i] 且 height[j] > height[j - 1]
        int len = height.length;
        int left = 0, right = len - 1;
        int leftMax = height[left], rightMax = height[right];
        left++;
        right--;
        int res = 0;
        while (left <= right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax){
                res += leftMax - height[left];
                left++;
            }
            else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
