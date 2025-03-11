package org.review._25_03;

public class Code_25_03_11_59 {
    public int[][] generateMatrix(int n) {
        // 返回数据
        int[][] res = new int[n][n];
        // 开始节点
        int x = 0, y = 0;
        // 每次螺旋长度
        int line = n - 1;
        // 螺旋次数
        int loop = n / 2;
        // 序号
        int index = 1;
        for (int p = 0; p < loop; p++) {
            int i = x, j = y;
            // 上
            for (; j < line; j++)
                res[i][j] = index++;
            // 右
            for (; i < line; i++)
                res[i][j] = index++;
            // 下
            for (; j > x; j--)
                res[i][j] = index++;
            // 左
            for (; i > x; i--)
                res[i][j] = index++;

            // 开始节点变更
            x = x + 1;
            y = y + 1;
            // 边长减少
            line = line - 2;
        }
        // 如果n为奇数，则补充中心节点
        if (n % 2 == 1)
            res[n / 2][n / 2] = index;
        return res;
    }
}
