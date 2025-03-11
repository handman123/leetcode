package org.learning.code.num501_1000;

import org.learning.node.TreeNode;

import java.util.Stack;

public class Code530 {

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;
        Stack<TreeNode> stack = new Stack<>();
        // 指针
        TreeNode cur = root;
        TreeNode pre = null;
        // 最小差值
        int minSub = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()){
            if (minSub == 1)
                return 1;
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                if (pre != null){
                    minSub = Math.min(cur.val - pre.val, minSub);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return minSub;
    }
}
