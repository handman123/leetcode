package org.learning.code.num101_500;


import org.learning.node.TreeNode;

public class Code106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0)
            return null;
        return dfs(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode dfs(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        // 退出条件
        if (inStart > inEnd || postStart > postEnd)
            return null;
        // 获取中间节点
        TreeNode root = new TreeNode(postorder[postEnd]);
        // 找到中间节点在inorder中位置
        int p = inStart;
        for (; p <= inEnd; p++) {
            if (inorder[p] == postorder[postEnd])
                break;
        }
        // 根据中间节点，切割两份
        root.left = dfs(inorder, inStart, p - 1, postorder, postStart, postStart + p - inStart);
        root.right = dfs(inorder, p + 1, inEnd, postorder, postStart + p - inStart + 1, postEnd - 1);
        return root;
    }
}
