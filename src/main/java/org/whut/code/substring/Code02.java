package org.whut.code.substring;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *     239. 滑动窗口最大值
 * </p>
 * <p>
 *     给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * </p>
 * <p>
 *     返回 滑动窗口中的最大值 。
 * </p>
 */
public class Code02 {

    // 双向队列：固定大小为k，当入队值大于队内元素，队内元素出队
    // 向右移动，左侧出队？ 问题：如何保证左侧元素是要出队的元素。
    // map记录元素下标？当左侧元素下标小于start，出队。重复元素怎么办？
    // 理解错题意
//    public int[] maxSlidingWindow(int[] nums, int k) {
//
//        int sum = 0;
//        int[] res = new int[nums.length - k + 1];
//        int p = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int start = i - k + 1;
//            sum += nums[i];
//            if (start < 0)
//                continue;
//            res[p++] = sum;
//            sum -= nums[start];
//        }
//        return res;
//    }

    // 将下标存入队列，即可判断队首元素是否出要出队。
    // Deque即可定义双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i - k + 1;
            // 入队
            // 判断队首下标，出了滑动窗口则出队
            if (!queue.isEmpty() && queue.peekFirst() < start)
                queue.pollFirst();

            // 入队元素比队尾元素小，队尾出队
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.removeLast();
            }

            // 入队元素比队首元素大，队首出队
            while (!queue.isEmpty() && nums[queue.peekFirst()] < nums[i]){
                queue.removeFirst();
            }

            // 入队元素小于等于队尾，或为空队，入队
            if (queue.isEmpty() || nums[queue.peekLast()] >= nums[i])
                queue.offer(i);

            if (start < 0)  // 窗口未填满，跳过
                continue;
            res[p++] = nums[queue.peekFirst()];
        }
        return res;
    }
}
