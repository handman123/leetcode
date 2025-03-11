package org.review._25_03;

import java.util.*;

public class Code_25_03_10_347 {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        // 统计各个元素出现频率
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        // 转化为数组
        Queue<int[]> queue = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
        for (Integer i : map.keySet()) {
            if (queue.size() < k)
                queue.add(new int[]{i, map.get(i)});
            else if (queue.peek()[1] < map.get(i)) {
                queue.poll();
                queue.add(new int[]{i, map.get(i)});
            }
        }
        // 输出
        int[] res = new int[k];
        for (int i = 0; i < k; i++)
            res[i] = queue.poll()[0];

        return res;
    }
}
