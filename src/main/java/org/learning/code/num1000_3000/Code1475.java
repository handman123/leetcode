package org.learning.code.num1000_3000;

public class Code1475 {
    /**
     */
    public boolean checkPartitioning(String s) {
        int len = s.length();
        // 特殊处理
        if (len < 3)
            return false;
        // isPal
        boolean[][] isPal = new boolean[len][len];
        // 循环
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j)
                    isPal[i][j] = true;
                else if (i + 1 == j && s.charAt(i) == s.charAt(j))
                    isPal[i][j] = true;
                else if (s.charAt(i) == s.charAt(j) && isPal[i + 1][j - 1])
                    isPal[i][j] = true;
            }
        }
        // 查找
        for (int i = 0; i < len - 2; i++) {
            for (int j = i; j < len - 1; j++) {
                if (isPal[0][i] && isPal[i + 1][j] && isPal[j + 1][len - 1])
                    return true;
            }
        }
        return false;

    }

}
