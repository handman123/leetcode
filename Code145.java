import node.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Code145 {

    // 迭代
    // 前序：中 -> 左 -> 右
    // 后序：左 -> 右 -> 中
    // 中 -> 左 -> 右  --->   中 -> 右 -> 左  --->     左 -> 右 -> 中
    public List<Integer> postorderTraversal(TreeNode root) {
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
            if (root_.left != null) stack.push(root_.left);
            if (root_.right != null) stack.push(root_.right);
        }
        // 数组反转
        int i = 0, j = res.size() - 1;
        while (i < j) {
            int temp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, temp);
            i++;
            j--;
        }
        return res;
    }


//    // 递归
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        dfs(root, res);
//        return res;
//    }
//
//    private void dfs(TreeNode root, List<Integer> list){
//        if (root == null)
//            return;
//        dfs(root.left, list);
//        dfs(root.right, list);
//        list.add(root.val);
//    }
}
