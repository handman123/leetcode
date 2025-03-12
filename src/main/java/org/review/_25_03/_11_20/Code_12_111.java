package org.review._25_03._11_20;

import org.review.node.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Code_12_111 {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int index = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            index++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null)
                    return index;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
        }
        return index;
    }
}
