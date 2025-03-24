package org.whut.code.array;

import java.util.*;

/**
 * <p>
 *     56. 合并区间
 * </p>
 * <p>
 *     以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * </p>
 */
public class Code02 {
    /**
     * 思路：对区间排序，按照左右区间大小从小到达排序，左区间优先，当左区间相等，按照右区间从小到大排序
     * @param intervals 输入数组
     * @return  输出数组
     */
    public int[][] merge(int[][] intervals) {
        // 对数组排序
        Arrays.sort(intervals, (e1, e2) -> {
            if (e1[0] == e2[0])
                return Integer.compare(e1[1], e2[1]);
            else return Integer.compare(e1[0], e2[0]);
        });
        // 区间合并
        Deque<int[]> res = new ArrayDeque<>();
        for (int[] interval : intervals) {
            if (res.isEmpty())
                res.add(new int[]{interval[0], interval[1]});
            else if (res.peekLast()[1] >= interval[0]) { // 区间交叉
                int[] temp = res.pollLast();
                res.addLast(new int[]{Math.min(temp[0], interval[0]), Math.max(temp[1], interval[1])});
            } else {  // 不交叉
                res.addLast(new int[]{interval[0], interval[1]});
            }
        }
        // 生成返回数组
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++){
            result[i] = res.pollFirst();
        }
        return result;
    }

}
