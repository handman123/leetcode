package org.learning.code.num1_100;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * <p>
 *     给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * </p>
 */
public class Code28 {
    public int strStr(String haystack, String needle) {
        int len_h = haystack.length();
        int len_n = needle.length();

        // 求next数组
        int[] next = new int[len_n];
        int i = 1, pre_index = 0;
        while (i < len_n){
            if (needle.charAt(i) == needle.charAt(pre_index)){
                pre_index += 1;
                next[i] = pre_index;
                i++;
            }
            else {
                if (pre_index == 0){
                    next[i] = 0;
                    i++;
                }
                else {
                    pre_index = next[pre_index - 1];
                }
            }
        }

        // 根据next数组，匹配字符串
        i = 0;
        int j = 0;
        while (j < len_n && i < len_h){
            // 都匹配，同时后移
            if (haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            // 不相等，j前移
            else {
                j = next[j - 1];
            }
        }
        // 结果判断
        if (j == len_n){
            return i - j;
        }
        else return -1;
    }
}
