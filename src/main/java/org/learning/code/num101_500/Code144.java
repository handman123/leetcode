package org.learning.code.num101_500;

import org.learning.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Code144 {


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // 边界条件
        if (root == null)
            return res;
        // 生成栈
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        // 迭代
        while (!stack.isEmpty()){
            TreeNode root_ = stack.pop();
            res.add(root_.val);
            if (root_.right != null) stack.push(root_.right);
            if (root_.left != null) stack.push(root_.left);
        }
        return res;
    }

//    // 递归
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        dfs(root, res);
//        return res;
//    }
//
//    private void dfs(TreeNode root, List<Integer> list){
//        if (root == null)
//            return;
//        list.add(root.val);
//        dfs(root.left, list);
//        dfs(root.right, list);
//    }
}
