package org.learning.code.num501_1000;

import org.learning.node.TreeNode;

import java.util.*;

public class Code501 {
    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[]{};
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        List<Integer> list = new ArrayList<>();
        int curValue = Integer.MIN_VALUE;
        int curNums = 0;
        int maxNum = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
//                list.add(cur.val);
                // 优化，将查找放到遍历中
                // 统计value出现次数
                if (pre != null && cur.val == curValue){
                    curNums++;
                } else {
                    curNums = 0;
                    curValue = cur.val;
                }
                if (curNums > maxNum){
                    res.clear();
                    res.add(curValue);
                    maxNum = curNums;
                }
                else if (curNums == maxNum){
                    res.add(curValue);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        // 遍历list
//        int curValue = list.get(0);
//        int curNums = 1;
//        int maxNum = Integer.MIN_VALUE;
//        List<Integer> res = new ArrayList<>();
//        res.add(curValue);
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i) == curValue){
//                curNums++;
//            }
//            else {
//                curNums = 1;
//                curValue = list.get(i);
//            }
//            if (curNums == maxNum){
//                res.add(curValue);
//            }
//            else if (curNums > maxNum){
//                maxNum = curNums;
//                res.clear();
//                res.add(curValue);
//            }
//        }
        // 找到最多的几个
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            result[i] = res.get(i);
        return  result;
    }
}
