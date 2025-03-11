package org.learning.code.num101_500;

import org.learning.node.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Code111 {

    // v3 层次遍历
    public int minDepth(TreeNode root) {
        // 特殊处理
        if (root == null)
            return 0;
        // 队列
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        // 循环
        int depth = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null)
                    return depth;
                if (node.right != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return depth;
    }

    // v2 递归基础上剪枝
//    private static int minDepth;
//
//    public int minDepth(TreeNode root) {
//        minDepth = Integer.MAX_VALUE;
//        dfs(root, 0);
//        return minDepth;
//    }
//
//    // 效率优化
//    private void dfs(TreeNode root, int depth){
//        if (minDepth >= depth)
//            return;
//        if (root == null)
//            return;
//        depth++;
//        if (root.left == null && root.right == null)
//            minDepth = Math.min(minDepth, depth);
//        dfs(root.left, depth);
//        dfs(root.right, depth);
//    }

    // v1 深度
//    private int dfs(TreeNode root){
//        if (root == null)
//            return 0;
//        int leftMinDepth = dfs(root.left);
//        int rightMinDepth = dfs(root.right);
//
//        // 左子树为空，右子树不为空
//        if (root.left == null && root.right != null)
//            return rightMinDepth + 1;
//
//        // 右子树为空，左子树不为空
//        if (root.left != null && root.right == null)
//            return leftMinDepth + 1;
//
//        // 左右子树都不为空
//        return Math.min(leftMinDepth, rightMinDepth) + 1;
//    }


}
