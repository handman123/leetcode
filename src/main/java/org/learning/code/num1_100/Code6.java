package org.learning.code.num1_100;

import java.util.ArrayList;
import java.util.List;

public class Code6 {

    public String convert(String s, int numRows) {
        // 特殊条件处理
        int len = s.length();

        if (len <= 1)
            return s;
        // 初始化
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        // 循环处理
        int i = 0, flag = -1;
        for (char c : s.toCharArray()){
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        // 拼接
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list){
            res.append(sb);
        }
        return res.toString();
    }
}
