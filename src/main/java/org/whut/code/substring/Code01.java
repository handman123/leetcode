package org.whut.code.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     560. 和为 K 的子数组
 * </p>
 * <p>
 *     给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * </p>
 * <p>
 *     子数组是数组中元素的连续非空序列。
 * </p>
 */
public class Code01 {

    // 滑动窗口有负数，无法解决问题
//    public int subarraySum(int[] nums, int k) {
//        int start = 0;
//        int sum = 0;
//        int subNum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            while (sum >= k && start <= i){
//                if (sum == k)
//                    subNum++;
//                sum -= nums[start];
//                start++;
//            }
//        }
//        return subNum;
//    }

    // 前缀和 + 哈希表优化
    // 前缀数组：pre[i]：表示为，[0...i]个元素和
    // 那么[i...j]个元素和：pre[j] - pre[i - 1]
    // 现在 k = pre[j] - pre[i - 1]
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : nums){
            pre += i;
            if (map.containsKey(pre - k))
                count += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
