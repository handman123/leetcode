package org.whut.code.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     1. 两数之和
 * </p>
 * <p>
 *     给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * </p>
 * <p>
 *     你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * </p>
 * <p>
 *     你可以按任意顺序返回答案。
 * </p>
 */
public class Code_01 {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            else map.put(nums[i], i);
        }
        return new int[]{};
    }
}
