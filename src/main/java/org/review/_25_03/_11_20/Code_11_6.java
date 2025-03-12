package org.review._25_03._11_20;

import java.util.ArrayList;
import java.util.List;

public class Code_11_6 {

    public String convert(String s, int numRows) {

        // 生成返回数组
        List<StringBuilder> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            res.add(new StringBuilder());
        }
        // flag标记
        int i = 0;
        int flag = -1;
        for (char c : s.toCharArray()){
            res.get(i).append(c);
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        // 拼接
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < res.size(); j++) {
            result.append(res.get(j));
        }
        return result.toString();
    }
}
