package org.whut.code.sliding_window;

import java.util.*;

/**
 * <p>
 *     438. 找到字符串中所有字母异位词
 * </p>
 * <p>
 *     给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * </p>
 */
public class Code02 {

    // map改为数组
    public List<Integer> findAnagrams(String s, String p) {
        // 字符串长度
        int lenP = p.length();
        int lenS = s.length();
        // 返回结果
        List<Integer> res = new ArrayList<>();
        // 统计p中各个字母的数量
        int[] hashMap = new int[26];
        for (char c : p.toCharArray()){
            hashMap[c - 'a']++;
        }
        // 滑动窗口遍历s
        int[] temp = new int[26];
        for (int i = 0; i < lenS; i++){
            char c = s.charAt(i);
            temp[c - 'a']++;
            int left = i - lenP + 1;
            if (left < 0)
                continue;
            if (Arrays.equals(temp, hashMap))
                res.add(left);
            temp[s.charAt(left) - 'a']--;
        }
        return res;
    }

//    // 比较字符串转为比较字符出现次数
//    public List<Integer> findAnagrams(String s, String p) {
//        // 字符串长度
//        int lenP = p.length();
//        int lenS = s.length();
//        // 返回结果
//        List<Integer> res = new ArrayList<>();
//        // 统计p中各个字母的数量
//        Map<Character, Integer> map = new HashMap<>();
//        for (char c : s.toCharArray()){
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        // 滑动窗口
//        Map<Character, Integer> temp = new HashMap<>();
//        System.out.println("map = " + map);
//        for (int i = 0; i < lenS - lenP + 1; i++ ){
//            System.out.println("temp = " + temp);
//            int left = i - lenP + 1;
//            temp.put(s.charAt(i), temp.getOrDefault(s.charAt(i), 0) + 1);
//            if (left < 0)
//                continue;
//            if (isEqual(map, temp))
//                res.add(left);
//            if (temp.get(s.charAt(left)) == 1)
//                temp.remove(s.charAt(left));
//            else temp.put(s.charAt(left), temp.get(s.charAt(left)) - 1);
//        }
//        return res;
//    }
//
//    private boolean isEqual(Map<Character, Integer> map1, Map<Character, Integer> map2){
//        for (char c : map1.keySet()){
//            if (!map2.containsKey(c) || !map1.get(c).equals(map2.get(c))){
//                return false;
//            }
//        }
//        return true;
//    }

//    // 低效率
//    public List<Integer> findAnagrams(String s, String p) {
//        // 字符串长度
//        int lenP = p.length();
//        int lenS = s.length();
//        // 返回结果
//        List<Integer> res = new ArrayList<>();
//        // 对字符串p排序
//        char[] pChars = p.toCharArray();
//        Arrays.sort(pChars);
//        String pNew = new String(pChars);
//        // 以长度为lenP的窗口向右边滑动，每次滑动一格。
//        for (int i = 0; i < lenS - lenP + 1; i++) {
//            String temp = s.substring(i, i + lenP);
//            char[] temp_chars = temp.toCharArray();
//            Arrays.sort(temp_chars);
//            if (new String(temp_chars).equals(pNew))
//                res.add(i);
//        }
//        return res;
//    }
}
