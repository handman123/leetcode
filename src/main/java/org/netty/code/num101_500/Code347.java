package org.netty.code.num101_500;

import java.util.*;

public class Code347 {

    // hash, 统计各个元素出现次数，然后遍历hash
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // 生成hashmap
        for (int item : nums){
//            if (map.containsKey(item)){
//                map.replace(item, map.get(item) + 1);
//            }
//            else map.put(item, 1);
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        // 堆排序，小根堆，只插入比对顶元素大的值，如果堆长度等于k，则移除对顶元素，插入新数据
        Queue<int[]> PQ = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));

        System.out.println("map = " + map);

        // 数据插入，
        for (Integer key : map.keySet()){
            if (PQ.size() < k)// 堆未满，插入
                PQ.add(new int[]{map.get(key), key});
            else if (PQ.peek() != null && map.get(key) > PQ.peek()[0]) {
                PQ.poll();
                PQ.offer(new int[]{map.get(key), key});
            }
        }

        // 数据输出
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k && !PQ.isEmpty(); i++){
            res.add(PQ.poll()[1]);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
