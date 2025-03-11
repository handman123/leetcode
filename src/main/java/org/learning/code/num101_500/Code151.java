package org.learning.code.num101_500;

import java.util.Arrays;

public class Code151 {
    public String reverseWords(String s) {
        // 1. 删除多余空格
        char[] chars = deleteExtraSpace(s.toCharArray());
        if (chars == null)
            return "";
        int len = chars.length;
        // 2. 反转全部字符串
        reverse(chars, 0, chars.length - 1);
        // 3. 遍历字符串，反转单词
        for (int i = 0, j = 0; j < len; j++){
            if (chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            else if(j == len - 1){
                reverse(chars, i, j);
                break;
            }
        }
        // 4. 返回结果
        return new String(chars);
    }

    // 去掉多余空格
    private char[] deleteExtraSpace(char[] chars){
        int len = chars.length;
        int slowIndex = 0, quickIndex = 0;
        if (len < 1)
            return chars;
        // 去掉头部空格
        while (quickIndex < len &&chars[quickIndex] == ' ') quickIndex++;
        if (quickIndex == len)  // 全部是空格
            return null;
        // 去掉中间空格
        while (quickIndex < len){
//            System.out.println("slowIndex = " + slowIndex);
//            System.out.println("quickIndex = " + quickIndex);
            if (quickIndex - 1 > 0 &&
                    chars[quickIndex] == chars[quickIndex - 1] &&
                    chars[quickIndex] == ' '
            ){
                quickIndex++;
            }
            else {
                chars[slowIndex++] = chars[quickIndex++];
            }
        }
        // 去掉末尾空格
         if (slowIndex - 1 > 0 && chars[slowIndex - 1] == ' ')
             slowIndex--;
        // 返回数组
        return Arrays.copyOfRange(chars, 0 , slowIndex);
    }

    // 反转指定范围字符
    private void reverse(char[] chars, int x, int y){
        while (x < y){
            char temp = chars[x];
            chars[x] = chars[y];
            chars[y] = temp;
            x++;
            y--;
        }
    }
}
