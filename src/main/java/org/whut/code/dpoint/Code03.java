package org.whut.code.dpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     15. 三数之和
 * </p>
 * <p>
 *     给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * </p>
 */
public class Code03 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3)
            return res;
        // 返回结果
        // 排序
        Arrays.sort(nums);
        // 遍历
        for (int i = 0; i < nums.length - 2; i++) {
            // 减枝
            if (nums[i] > 0)
                break;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 双指针
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    res.add(list);
                    // 去重
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[start - 1]) end--;
                    // 缩容
                    start++;
                    end--;
                }
                else if (sum > 0)
                    end--;
                else start++;
            }
        }
        return res;
    }
}
