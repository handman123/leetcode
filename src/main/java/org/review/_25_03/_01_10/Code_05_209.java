package org.review._25_03._01_10;

import java.util.Arrays;

public class Code_05_209 {

    // 未能解决 问题
    private static int minNums;
    private static int sum;
    private static int numbers;
    // 回溯法，先排序，后回溯，
    public int minSubArrayLen(int target, int[] nums) {
        // 1. 排序
        Arrays.sort(nums);
        // 2. 初始化
        minNums = Integer.MAX_VALUE;
        sum = 0;
        numbers = 0;
        // 3. 回溯
        dfs(nums, 0, target);
        return minNums == Integer.MAX_VALUE ? 0 : minNums;
    }

    private void dfs(int[] nums, int start, int target) {
        if (start == nums.length)
            return;
        if (sum == target){
            minNums = Math.min(minNums, numbers);
            return;
        }
        if (sum > target)
            return;
        // 循环
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                return;
            if (sum + nums[i] <= target) {
                sum += nums[i];
                numbers++;
                dfs(nums, i + 1, target);
                sum -= nums[i];
                numbers--;
            }
            else break;
        }
    }


//    // 思路错误
//    public int minSubArrayLen(int target, int[] nums) {
//        // 1. 排序
//        Arrays.sort(nums);
//        // 2. 滑动窗口。sum >= target i++, sum < target j++
//        // 统计sum = target时，出现几个元素，记录最小次数
//        int j = 1;
//        int minNums = Integer.MAX_VALUE;
//        int sum = nums[0];
//        for (int i = 0; i < nums.length; ) {
////            System.out.println("i = " + i);
////            System.out.println("sum = " + sum);
//            // [i...j]
//            if (sum < target) {
//                if (j == nums.length)
//                    break;
//                while (j < nums.length && sum < target) {
//                    sum += nums[j++];
//                }
//            }
//            else if (sum == target){
//                minNums = Math.min(minNums, j - i);
//                sum -= nums[i];
//                i++;
//            }
//            else if (sum > target){
//                sum -= nums[i];
//                i++;
//            }
//        }
//        return minNums == Integer.MAX_VALUE ? 0 : minNums;
//    }
}
