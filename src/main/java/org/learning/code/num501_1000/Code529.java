package org.learning.code.num501_1000;

public class Code529 {
    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0], j = click[1];
        // 判断是否为地雷
        if (board[i][i] == 'M'){
            board[i][j] = 'X';
            return board;
        }
        // 不是地雷，判断周围是否有地雷
        int mNum = hasM(board, i, j);
        // 周围有地雷
        if (mNum > 0){
            board[i][j] = (char) mNum;
            return board;
        }
        // 周围没有地雷
        dfs(board, i, j);
        return board;
    }

    // 递归揭露
    private void dfs(char[][] board, int i, int j){
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length)
            return;
        // 如果是数字、或地雷或已经揭露，则退出
        if (board[i][j] == 'M' || board[i][j] == 'E' || board[i][j] >= '0' && board[i][j] <= 8)
            return;
        // 判断当前点是否含有地雷
        int mNum = hasM(board, i, j);
        // 有地雷
        if (mNum > 0){
            board[i][j] = (char) (mNum + '0');
            return;
        }
        // 无地雷，递归
        board[i][j] = 'E';
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i - 1, j - 1);
        dfs(board, i - 1, j + 1);
        dfs(board, i + 1, j - 1);
        dfs(board, i + 1, j + 1);
    }

    // 判断某个点周围是否有地雷
    private int hasM(char[][] board, int i, int j){
        int mNum = 0;
        if (isM(board, i, j - 1)){
            mNum++;
        }
        if (isM(board, i, j + 1)){
            mNum++;
        }
        if (isM(board, i - 1, j - 1)){
            mNum++;
        }
        if (isM(board, i - 1, j + 1)){
            mNum++;
        }
        if (isM(board, i - 1, j)){
            mNum++;
        }
        if (isM(board, i + 1, j + 1)){
            mNum++;
        }
        if (isM(board, i + 1, j - 1)){
            mNum++;
        }
        if (isM(board, i + 1, j)){
            mNum++;
        }
        return mNum;
    }

    // 判断某个点是否为地雷
    private boolean isM(char[][] board, int i, int j){
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length)
            return false;
        return board[i][j] == 'M';
    }
}
