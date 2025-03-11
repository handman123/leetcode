package _25_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_25_3_8_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        int len = nums.length;

        // 结果数组
        List<List<Integer>> res = new ArrayList<>();

        // 边界条件
        if (len < 4)
            return res;

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = len - 1;
                long sum = (long) nums[i] + (long) nums[j] + (long) nums[j + 1] + (long) nums[j + 2];
                if (sum > target)   // 剪枝
                    continue;
                while (left < right){
                    sum = (nums[i] + nums[j] + nums[left] + nums[right]);
                    if (sum > target)
                        right--;
                    else if (sum < target)
                        left++;
                    else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(temp);
                        // 去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }

        return res;
    }
}
