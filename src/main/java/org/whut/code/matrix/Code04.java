package org.whut.code.matrix;

/**
 * <p>
 *     240. 搜索二维矩阵 II
 * </p>
 * <p>
 *     编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * </p>
 * <p>
 *     每行的元素从左到右升序排列。
 * </p>
 * <p>
 *     每列的元素从上到下升序排列。
 * </p>
 */
public class Code04 {

    /**
     * 思路：从右上角开始，每次与该值和该值下面、左边比较。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int x = 0, y = n - 1;

        while (x < m && y >= 0){
            if (matrix[x][y] == target)
                return true;

            else if (matrix[x][y] > target){
                y--;
            }

            else {
                x++;
            }
        }

        return false;
    }
}
