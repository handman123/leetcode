package org.whut.code.hash;

import java.util.*;

/**
 * <p>
 *     49. 字母异位词分组
 * </p>
 * <p>
 *     给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * </p>
 * <p>
 *     字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * </p>
 */
public class Code_02 {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int nums = 0;
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            // 有字母异位词
            if (map.containsKey(temp))
                res.get(map.get(temp)).add(str);
            else {
                map.put(temp, nums++);
                List<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
            }
        }
        return res;
    }
}
