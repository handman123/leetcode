// 问题：不要用静态变量，当多次调用时，可能会产生结果冲突

import node.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Code104 {

    // 递归法
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // 迭代法
//    public int maxDepth(TreeNode root) {
//        // 特殊条件处理
//        if (root == null)
//            return 0;
//
//        // 队列
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        queue.add(root);
//        int depth = 0;
//        while (!queue.isEmpty()){
//            int size = queue.size();
//            depth++;
//            for (int i = 0; i < size; i++) {
//                TreeNode poll = queue.poll();
//                if (poll.left != null) queue.add(poll.left);
//                if (poll.right != null) queue.add(poll.right);
//            }
//        }
//        return depth;
//    }








































    //    public int maxDepth(TreeNode root) {
//        if (root == null)
//            return 0;
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }

}
