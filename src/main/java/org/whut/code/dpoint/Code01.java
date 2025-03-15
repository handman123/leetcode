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
public class Code01 {

    /**
     * 双指针移动
     * @param nums 输入数组
     */
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length){
            if (nums[right] != 0){
                nums[left] = nums[right];
                left++;
                right++;
            }
            else right++;
        }
        // left遍历到末尾，将后面元素填充为0
        while (left < nums.length){
            nums[left++] = 0;
        }
    }
}
