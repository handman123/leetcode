package org.review._25_03._11_20;

public class Code_11_151 {

    public String reverseWords(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        // 反转整个字符串
        reverse(chars, 0, len - 1);
        // 双指针，去掉所有空格
        // 去掉首部空格
        int start = 0, end = 0;
        while (end < len && chars[end] == ' ') end++;
        if (end >= len) return null;    // 全部是空格
        while (end < len){
            if (chars[end] == chars[end - 1] && chars[end] == ' ')
                end++;
            else {
                chars[start++] = chars[end++];
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.println(chars[i]);
        }
        // 判断末尾是否有空格
        if (chars[start - 1] == ' ') start = start - 1;
        // 反转单词
        len = start;
        start = 0;
        end = 0;
        System.out.println(len);
        while (end < len){
            if (chars[end] == ' '){
                reverse(chars, start, end - 1);
                start = end + 1;
                end = end + 1;
            }
            else if (end == len - 1) {
                reverse(chars, start, end - 1);
                break;
            }
            else end++;
        }
        for (int i = 0; i < s.length(); i++) {
            System.out.println(chars[i]);
        }
        // 返回结果
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            res.append(chars[i]);
        }
        return res.toString();
    }

    // 反转字符串中[start...end]字符串
    private void reverse(char[] chars, int start, int end){
        if (start >= end)
            return;
        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
