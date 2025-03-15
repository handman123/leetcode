package org.whut.code.hash;

import java.util.Set;
import java.util.TreeSet;

/**
 * <p>
 *     128. 最长连续序列
 * </p>
 * <p>
 *     给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * </p>
 * <p>
 *     请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * </p>
 */
public class Code_03 {
    /**
     * 1. 用map存储数字
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        // set去重
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longestStreak = 0;
        // 遍历
        for(int i : set){
            if (!set.contains(i - 1)){
                int currentNum = i;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;

    }
}
