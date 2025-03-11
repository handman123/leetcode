package org.netty.code.num101_500;

import node.TreeNode;

import java.util.*;

public class Code102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 返回结果
        List<List<Integer>> res = new ArrayList<>();
        // 特殊处理
        if (root == null)
            return res;
        // 队列
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
