package org.whut.code.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *     76. 最小覆盖子串
 * </p>
 * <p>
 *     给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * </p>
 * 注意：
 * <p>
 *     * 于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * </p>
 * <p>
 *     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * </p>
 */
public class Code03 {

    // 哈希表，滑动窗口
    // 两个哈希表，一个记录字符串t各个元素出现次数
    // 一个记录滑动窗口各个元素出现次数
    // 每次变动时，判断两个哈希表key是否相等，value是否大于
    // 可能小写，也可能大写，用map
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        // map填充
        for (char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 滑动窗口， 遍历s
        // 如果窗口内没有元素，则起始位置跳过
        Map<Character, Integer> map_s = new HashMap<>();
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int x = 0, y = 0;
        // System.out.println("map = " + map);
        for (int i = 0; i < s.length(); i++) {
            // System.out.println("i = " + i);
            // i指向的元素
            char c = s.charAt(i);
            // 找到map中包含的元素，添加到map_s中。
            if (map.containsKey(c)) {
                map_s.put(c, map_s.getOrDefault(c, 0) + 1);
                // 添加元素后，判断map_s内元素是否等于map
                // System.out.println("map_s = " + map_s);
                while (isMapEqual(map, map_s)){
                    if (minLen > i - start + 1){
                        minLen = i - start + 1;
                        x = start;
                        y = i;
                    }
                    // 移除起始位置，直到起始位置的元素在t中存在
                    if (map_s.get(s.charAt(start)) == 1)
                        map_s.remove(s.charAt(start));
                    else map_s.put(s.charAt(start), map_s.get(s.charAt(start)) - 1);
                    // System.out.println("map_s = " + map_s);
                    start++;
                    while (!map.isEmpty() && start <= i && !map.containsKey(s.charAt(start))){
                        start++;
                    }
                }
            }
            // 判断map_s是否为空，如果空，则start跳到i位置
            if (map_s.isEmpty()) start = i + 1;
        }
        // System.out.println("x = " + x);
        // System.out.println("y = " + y);
        return minLen == Integer.MAX_VALUE ? "" : s.substring(x, y + 1);
    }

    private boolean isMapEqual(Map<Character, Integer> map, Map<Character, Integer> map_s){
        for (char c : map.keySet()){
            if (!map_s.containsKey(c) || map_s.get(c) < map.get(c))
                return false;
        }
        return true;
    }
}
