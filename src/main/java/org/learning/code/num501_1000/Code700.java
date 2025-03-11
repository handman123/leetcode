package org.learning.code.num501_1000;

import org.learning.node.TreeNode;

public class Code700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        else if (val < root.val){
            return searchBST(root, val);
        }
        else return searchBST(root, val);
    }
}
