package org.learning.code.num101_500;

import org.learning.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Code257 {
    public List<String> binaryTreePaths(TreeNode root) {
        // 特殊返回
        if (root == null)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        dfs(root, list, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> list, List<String> res){
        // 退出条件
        if (node == null)
            return;
        list.add(node.val);
        // 到达叶子节点
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i : list){
                if (sb.length() == 0)
                    sb.append(i);
                else sb.append("->").append(i);
            }
            res.add(sb.toString());
        }
        // 左子树
        dfs(node.left, list, res);
        // 右子树
        dfs(node.right, list, res);
        // 退回
        list.remove(list.size() - 1);
    }
}
