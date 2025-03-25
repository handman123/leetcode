package org.whut.code.matrix;

/**
 * <p>
 *     73. 矩阵置零
 * </p>
 * <p>
 *     给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法
 * </p>
 */
public class Code01 {

    /**
     * 思路2：用第一行和第一列存储标记
     */
    public void setZeroes(int[][] matrix) {

        boolean zero_row = false;
        boolean zero_col = false;

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) zero_row = true;
                    if (j == 0) zero_col = true;
                }
            }
        }
//         for (int i = 0; i < matrix.length; i++){
//             for (int j = 0; j < matrix[0].length; j++){
//                 System.out.print(" " + matrix[i][j]);
//             }
//             System.out.println();
//         }
        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

//        System.out.println("row = " + row);
//        System.out.println("col = " + col);

        for (int i = 0; zero_row && i < matrix[0].length; i++)
            matrix[0][i] = 0;

        for (int i = 0; zero_col && i < matrix.length; i++)
            matrix[i][0] = 0;
    }

//    /**
//     * 思路1：用一个数组中不存在的数标记0，通过两次遍历
//     * @param matrix
//     */
//    public void setZeroes(int[][] matrix) {
//
//        // 遍历矩阵，找到0，将对应x行和y列非0置为2
//        for (int i = 0; i < matrix.length; i++){
//            for (int j = 0; j < matrix[0].length; j++){
//                if (matrix[i][j] == 0)
//                    setX(matrix, i, j, Integer.MIN_VALUE - 5);
//            }
//        }
//
//        // for (int i = 0; i < matrix.length; i++){
//        //     for (int j = 0; j < matrix[0].length; j++){
//        //         System.out.print(" " + matrix[i][j]);
//        //     }
//        //     System.out.println();
//        // }
//
//        // 再次遍历矩阵，将所有2改为1
//        for (int i = 0; i < matrix.length; i++){
//            for (int j = 0; j < matrix[0].length; j++){
//                if (matrix[i][j] == Integer.MIN_VALUE - 5)
//                    matrix[i][j] = 0;
//            }
//        }
//    }
//
//    // 将第x列所有元素和y列所有元素1设置为X
//    private void setX(int[][] matrix, int x, int y, int X){
//        int row = matrix.length;
//        if (row == 0)
//            return;
//        int line = matrix[0].length;
//
//        if (x >= row || y >= line || x < 0 || y < 0)
//            return;
//
//        for (int i = 0; i < line; i++){
//            if (matrix[x][i] != 0)
//                matrix[x][i] = X;
//        }
//
//        for (int i = 0; i < row; i++){
//            if (matrix[i][y] != 0)
//                matrix[i][y] = X;
//        }
//    }
}
