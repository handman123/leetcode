package org.whut.code.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *     54. 螺旋矩阵
 * </p>
 * <p>
 *     给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * </p>
 */
public class Code02 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        // 特殊返回
        if (matrix.length == 0)
            return res;

        // m*n
        int m = matrix.length;
        int n = matrix[0].length;

        // 初始化
        int x = 0, y = 0;   // 起始位置
        int loop = Math.min(m / 2 , n / 2);
        int width = n - 1;
        int height = m - 1;
        int i = y, j = x;

        // 循环遍历
        for (int q = 0; q < loop; q++) {
            i = y;
            j = x;

            // 上
            for (; i < x + width; i++) {
                res.add(matrix[x][i]);
            }

            // 右
            for (; j < y + height; j++) {
                res.add(matrix[j][i]);
            }

            // 下
            for (; i > x; i--) {
                res.add(matrix[j][i]);
            }

            // 左
            for (; j > y; j--) {
                res.add(matrix[j][i]);
            }

            // 下一圈起点
            x++;
            y++;

            // 下一圈长和宽
            width -= 2;
            height -=2;

        }

        // 收尾
        if (width == 0 || height == 0){
            for (int k = y; width != 0 && k <= y + width; k++) {
                res.add(matrix[x][k]);
            }

            for (int k = x; height != 0 && k <= x + height; k++) {
                res.add(matrix[k][y]);
            }

            if(width == 0 && height == 0 && m % 2 == 1)
                res.add(matrix[x][y]);
        }

        return res;
    }
}
