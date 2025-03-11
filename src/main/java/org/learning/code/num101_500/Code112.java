package org.learning.code.num101_500;

import org.learning.node.TreeNode;

public class Code112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return sum(root, targetSum, 0);
    }

    private boolean sum(TreeNode root, int targetSum, int sum){
        if (root == null)
            return false;
        if (root.left == null && root.right == null && sum == targetSum)
            return true;
        return sum(root, targetSum, sum + root.val) || sum(root, targetSum, sum + root.val);
    }
}
