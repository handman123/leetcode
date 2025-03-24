package org.whut.code.array;

/**
 * <p>
 *     189. 轮转数组
 * </p>
 * <p>
 *     给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * </p>
 */
public class Code03 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse_array(nums, 0, nums.length - 1);
        reverse_array(nums, 0, k - 1);
        reverse_array(nums, k, nums.length - 1);
    }

    private void reverse_array(int[] nums, int start, int end){
        if (start >= end || end >= nums.length)
            return;
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
