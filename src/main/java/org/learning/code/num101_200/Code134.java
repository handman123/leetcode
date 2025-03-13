package org.learning.code.num101_200;

public class Code134 {
//    // 暴力求解
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int len = gas.length;
//        // 依次遍历每个点
//        for (int i = 0; i < len; i++) {
//            // 从i点出发，判断是否能回到i点。
//            int gasInCar = 0;
//            for (int j = 0; j < len; j++) {
//                int p = (j + i) % len;
//                gasInCar += gas[p];
//                if (gasInCar < cost[p])
//                    break;
//                else if (gasInCar >= cost[p] && j == len - 1)
//                    return i;
//                gasInCar -= cost[p];
//            }
//        }
//        return -1;
//    }

    // 贪心1
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        int carGas = 0;
//        int min = Integer.MAX_VALUE;
//        // 1. 全局判断，如果油量总和小于消耗总和，那么永远也不可能循环
//        for (int i = 0; i < gas.length; i++) {
//            carGas += gas[i] - cost[i];
//            min = Math.min(carGas, min);
//        }
//        if (carGas < 0) return -1;
//        if (min >= 0) return 0;
//
//        for (int i = gas.length - 1; i > 0; i--){
//            int rest = gas[i] - cost[i];
//            min += rest;
//            if (min >= 0)
//                return i;
//        }
//        return -1;
//    }

    // 贪心2
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int curCost = 0;
        int allCost = 0;
        int startPoint = 0;
        for (int i = 0; i < len; i++) {
            curCost += gas[i] - cost[i];
            allCost += gas[i] - cost[i];
            if (curCost < 0){
                curCost = 0;
                startPoint = i + 1;
            }
        }
        if (allCost < 0)
            return -1;
        return startPoint;
    }
}
