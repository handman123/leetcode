package org.learning.code.num1_100;

import org.learning.node.TreeNode;

public class Code98 {
    /**
     * 二叉搜索树：
     *  左孩子小于父节点，右孩子大于父节点
     *  左子树最大值小于父节点
     *  右子树最小值大于父节点
     */
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null);
    }

    // 中序遍历，即可得到有序数组
    private boolean dfs(TreeNode root, TreeNode pre){
        if (root == null)
            return true;
        boolean left = dfs(root.left, pre);

        if (pre != null && pre.val >= root.val) return false;
        pre = root;

        boolean right = dfs(root.right, pre);

        return left && right;
    }
}
