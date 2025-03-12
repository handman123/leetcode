package org.learning.code.num201_500;

import java.util.Arrays;

public class Code455 {

    public int findContentChildren(int[] g, int[] s) {
        int gLen = g.length;
        int sLen = s.length;
        // 对孩子和饼干进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 倒叙
        int gi = gLen - 1;
        int si = sLen - 1;
        // 返回结果
        int res = 0;
        // 遍历
        while (gi >= 0 && si >=0){
            if (g[gi] <= s[si]){
                res++;
                gi--;
                si--;
            }
            else if (g[gi] > s[si])
                gi--;
        }
        return res;
    }
}
