package org.learning.code.num201_500;

import java.util.*;

public class Code452 {

    /**
     * 452.用最少数量的剑引爆气球
     * <p>
     * 思路：
     * </p>
     * <p>
     *     1. 对所有区间进行按照左区间排序
     * </p>
     * <p>
     *     2. 从左到右依次对区间取交集，交集数量即为弓箭数量
     * </p>
     *
     * @param points 气球位置
     * @return  消耗最小弓箭数量
     */
    public int findMinArrowShots(int[][] points) {
        // 排序
        Arrays.sort(points, (e1, e2) -> {
            if (e1[0] == e2[0])
                return Integer.compare(e1[1], e2[1]);
            else return Integer.compare(e1[0], e2[0]);
        });
        // 对集合取交集
        Stack<Integer[]> stack = new Stack<>();
        System.out.println("stack = " + Arrays.deepToString(points));
        for (int i = 0; i < points.length; i++){
            if (stack.isEmpty())
                stack.add(new Integer[]{points[i][0], points[i][1]});
            else {
                // 栈顶元素与当前区间可以取交集
                if (stack.peek()[1] >= points[i][0]){
                    Integer[] temp = stack.pop();
                    stack.push(new Integer[]{
                            Math.max(points[i][0], temp[0]),
                            Math.min(points[i][1], temp[1])
                    });
                }
                // 栈顶元素不可以取交集
                else stack.push(new Integer[]{points[i][0], points[i][1]});
            }
        }
        return stack.size();
    }
}
