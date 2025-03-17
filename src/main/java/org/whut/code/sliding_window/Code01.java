package org.whut.code.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     3. 无重复字符的最长子串
 * </p>
 * <p>
 *     给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 * </p>
 */
public class Code01 {

    public int lengthOfLongestSubstring(String s) {

        // 记录字符串是否存在，存在则记录其序号
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int maxLen = Integer.MIN_VALUE;
        for (; end < s.length(); end++){
            char c = s.charAt(end);
            if (map.containsKey(c) && map.get(s.charAt(c)) >= start){
                start = map.get(s.charAt(c));
            }
            map.put(c, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
