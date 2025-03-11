package org.netty.code.num1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            // if (nums[i] > target)   // 剪枝
            //     return res;
            if (i > 0 && nums[i] == nums[i - 1])    // 去重
                continue;
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                // if (nums[i] + nums[j] > target)     // 剪枝
                //     return res;
                if (j > i + 1 && nums[j] == nums[j - 1])    // 去重
                    continue;
                // 双指针
                int left = j + 1;
                int right = len - 1;
                while (left < right){
                    long temp = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (temp > target)
                        right--;
                    else if (temp < target)
                        left++;
                    else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        // 去重
                        while (left < right && nums[left + 1] == nums[left]) left++;
                        while (left < right && nums[right - 1] == nums[right]) right--;
                        // 没有重复元素或已经去重
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
