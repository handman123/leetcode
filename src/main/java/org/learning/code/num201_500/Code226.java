package org.learning.code.num201_500;

import org.learning.node.TreeNode;

public class Code226 {

    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node){
        if (node == null)
            return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        dfs(node.left);
        dfs(node.right);
    }
}
