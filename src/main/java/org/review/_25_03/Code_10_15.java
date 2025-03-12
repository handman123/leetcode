package org.review._25_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_10_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        // 结果返回
        List<List<Integer>> res = new ArrayList<>();
        // 数组排序
        Arrays.sort(nums);
        // 双指针
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0)    // 剪枝
                break;
            if (i > 0 && nums[i] == nums[i - 1])    // 去重
                continue;
            // 双指针
            int start = i + 1;
            int end = len - 1;
            while (start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > 0)
                    end--;
                else if (sum < 0)
                    start++;
                else {
                    // 添加结果
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    res.add(list);
                    // 去重
                    while (start < end && nums[start + 1] == nums[start]) start++;
                    while (start < end && nums[end - 1] == nums[end]) end--;
                    // 双指针靠拢
                    start++;
                    end--;
                }
            }

        }
        return res;
    }
}
