package org.learning.code.num101_200;

import java.util.Arrays;

public class Code135 {

    public int candy(int[] ratings) {
        int length = ratings.length;
        // 特殊返回
        if (length < 1)
            return 0;
        // 定义中间数组
        int[] candyLeft = new int[length];
        int[] candyRight = new int[length];
        // 循环
        // 从左向右，与左边节点比较
        for (int i = 0; i < length; i++){
            if (i == 0)
                candyLeft[i] = 1;
            else if (ratings[i] > ratings[i - 1])
                candyLeft[i] = candyLeft[i - 1] + 1;
            else candyLeft[i] = 1;
        }
        // 从右向左遍历
        int candys = 0;
        for (int i = length - 1; i >= 0; i--){
            if (i == length - 1)
                candyRight[i] = Math.max(1, candyLeft[i]);
            else if (ratings[i] > ratings[i + 1])
                candyRight[i] = Math.max(candyRight[i + 1] + 1, candyLeft[i]);
            else candyRight[i] = Math.max(1, candyLeft[i]);
            candys += candyRight[i];
        }
        return candys;
    }
}
