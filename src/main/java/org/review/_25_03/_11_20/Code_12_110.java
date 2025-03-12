package org.review._25_03._11_20;

import org.review.node.TreeNode;

public class Code_12_110 {
    public boolean isBalanced(TreeNode root) {
        return isBalanced_(root) != -1;
    }

    private int isBalanced_(TreeNode root){
        if (root == null)
            return 0;
        int leftDepth = isBalanced_(root.left);
        int rightDepth = isBalanced_(root.right);
        if (leftDepth == -1 || rightDepth == -1)
            return -1;
        if (leftDepth - rightDepth > 1 || leftDepth - rightDepth < -1)
            return -1;
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
