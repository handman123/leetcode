package org.netty.code.num101_500;

import node.TreeNode;

public class Code110 {

    // 递归 优化
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root){
        if (root == null)
            return 0;
        // 获取左子树深度
        int leftDepth = dfs(root.left);
        // 获取右子树深度
        int rightDepth = dfs(root.right);
        // 比较两颗子树深度差
        if (leftDepth == -1 || rightDepth == -1)
            return -1;
        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1)
            return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }
    // 递归
//    private static boolean flag;
//
//    public boolean isBalanced(TreeNode root) {
//        flag = true;
//        dfs(root);
//        return flag;
//    }
//
//    private int dfs(TreeNode root){
//        if (root == null)
//            return 0;
//        if (!flag)
//            return 0;
//        // 获取左子树深度
//        int leftDepth = dfs(root.left);
//        // 获取右子树深度
//        int rightDepth = dfs(root.right);
//        // 比较两颗子树深度差
//        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1)
//            flag = false;
//        return Math.max(leftDepth, rightDepth) + 1;
//    }
}
