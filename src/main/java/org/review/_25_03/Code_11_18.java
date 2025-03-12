package org.review._25_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_11_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        // 返回数组
        List<List<Integer>> res = new ArrayList<>();
        // 数组排序
        Arrays.sort(nums);
        // 特殊返回
        if (len < 4) return res;
        // 双循环
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)  // 剪枝
                    return res;
                int start = j + 1;
                int end = len - 1;
                while (start < end){
                    long sum = (long) nums[i] + nums[j] + nums[start] + nums[end];
                    if (sum == target){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);    list.add(nums[j]);
                        list.add(nums[start]);    list.add(nums[end]);
                        res.add(list);
                        // 去重
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    }
                    else if (sum < target) start++;
                    else end--;
                }
            }
        }
        return res;
    }
}
