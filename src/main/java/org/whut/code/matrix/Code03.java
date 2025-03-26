package org.whut.code.matrix;

/**
 * <p>
 *     48. 旋转图像
 * </p>
 * <p>
 *     给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度
 * </p>
 * <p>
 *     你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * </p>
 */
public class Code03 {

    public void rotate(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // 交换i != j 的值
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j);
            }
        }

        // 交换左右两列
        int start = 0, end = n - 1;
        while (start < end){
            for (int i = 0; i < m; i++){
                swap(matrix, i, start, end);
            }
            start++;
            end--;
        }
    }

    // 交换（x, y) 与 (y, x)
    private void swap(int[][] matrix, int x, int y){
        int temp = matrix[x][y];
        matrix[x][y] = matrix[y][x];
        matrix[y][x] = temp;
    }

    // 交换（x, y) 与 (x, y1)
    private void swap(int[][] matrix, int x, int y, int y1){
        int temp = matrix[x][y];
        matrix[x][y] = matrix[x][y1];
        matrix[x][y1] = temp;
    }
}
