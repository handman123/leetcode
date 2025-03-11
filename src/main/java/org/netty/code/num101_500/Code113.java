package org.netty.code.num101_500;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Code113 {

    private static List<List<Integer>> res;
    private static List<Integer> list;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 初始化
        res = new ArrayList<>();
        list = new ArrayList<>();
        dfs(root, targetSum, 0);
        return res;
    }

    private void dfs(TreeNode root, int targetSum, int sum){
        if (root == null)
            return;
        sum += root.val;
        list.add(root.val);
        // 找到一条路径
        if (sum == targetSum && root.left == null && root.right == null){
            res.add(list);
            return;
        }
        // 递归
        dfs(root.left, targetSum, sum);
        dfs(root.right, targetSum, sum);
        // 出栈
        list.remove(list.size() - 1);
    }
}
