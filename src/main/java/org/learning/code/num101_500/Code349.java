package org.learning.code.num101_500;

import java.util.ArrayList;
import java.util.List;

public class Code349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hash = new int[1001];
        // 遍历nums1
        for (int i = 0; i < nums1.length; i++) {
            hash[nums1[i]] = 1;
        }
        List<Integer> res = new ArrayList<>();
        // 遍历nums2
        for (int i = 0; i < nums2.length; i++) {
            if (hash[nums2[i]] > 0){
                res.add(nums2[i]);
                hash[nums2[i]]--;
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
}
