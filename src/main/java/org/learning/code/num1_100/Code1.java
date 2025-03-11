package org.learning.code.num1_100;

import java.util.HashMap;
import java.util.Map;

public class Code1 {
//    /**
//     * 思路1：对数组排序（nlogn），然后双指针查找
//     * 不可行
//     */
//    public int[] twoSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        int temp = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                temp = nums[i] + nums[j];
//                if (temp == target)
//                    return new int[]{i, j};
//                else if (temp > target)
//                    break;
//            }
//        }
//        return new int[]{0, 0};
//    }

    /**
     * 思路2：将所有值存入hash表中，对target从1开始遍历，找到两个可以相加为target值
     * 问题：存在重复值
     * 解决：边生成hash，边判断
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (hash.containsKey(temp))
                return new int[]{i, hash.get(temp)};
            hash.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
}
