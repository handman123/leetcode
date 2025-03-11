import node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Code94 {

    // 迭代
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

//    // 递归
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        dfs(root, res);
//        return res;
//    }
//
//    private void dfs(TreeNode root, List<Integer> list){
//        if (root == null)
//            return;
//        dfs(root.left, list);
//        list.add(root.val);
//        dfs(root.right, list);
//    }
}
