package org.whut.code.array;

import sun.security.util.ArrayUtil;

import java.util.Arrays;

/**
 * <p>
 *     41. 缺失的第一个正数
 * </p>
 * <p>
 *     给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * </p>
 * <p>
 *     请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * </p>
 */
public class Code05 {

    /**
     * 原地hash：i 位置，存放值 i + 1
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            // 遍历每个数，如果当前数不在指定位置，将其与指定位置交换
            while (nums[i] != i + 1 &&
                    nums[i] - 1 < nums.length &&
                    nums[i] - 1 >= 0 &&
                    nums[nums[i] - 1] != nums[i]){
                swap(nums, i , nums[i] - 1);
            }
        }

        // 遍历hash数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        System.out.println("nums = " + Arrays.toString(nums));
        return nums.length + 1;
    }

    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
