package org.learning.code.num101_200;


import org.learning.node.TreeNode;

public class Code101 {

    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    // 判断左右子树是否相等
    private boolean check(TreeNode left, TreeNode right){
        if (left == null && right != null)  // 左空，右非空
            return false;
        else if (left != null && right == null) // 左非空，右空
            return false;
        else if (left == null && right == null) // 左右都为空
            return true;
        else if (left.val != right.val) // 左右非空，且值不相等
            return false;
        // 左右非空，且值相等

        // 判断，左子树左节点，与右子树右节点是否相等
        boolean isEqualOut = check(left.left, right.right);

        // 判断，左子树右节点，与右子树左节点是否相等
        boolean isEqualInner = check(left.right, right.left);

        // 左右子树是否都满足内外对称
        boolean isEqual = isEqualOut && isEqualInner;

        // 返回结果
        return isEqual;
    }



//    public boolean isSymmetric(TreeNode root) {
//        return check(root.left, root.right);
//    }
//
//    private boolean check(TreeNode left, TreeNode right){
//        if (left == null && right == null)
//            return true;
//        if (left == null || right == null)
//            return false;
//        return
//                left.val == right.val &&
//                        check(left.left, right.right) &&
//                        check(left.right, right.left);
//    }


//    // 问题：部分特殊输入无法判断
//    private static List<Integer> roots;
//
//    public boolean isSymmetric(node.TreeNode root) {
//        // 特殊条件处理
//        if(root == null)
//            return true;
//        // 初始化
//        roots = new ArrayList<>();
//        // 中序遍历
//        dfs(root);
//        // 处理数组
//        int i = 0, j = roots.size() - 1;
//        while (i < j){
//            if (!Objects.equals(roots.get(i), roots.get(j)))
//                return false;
//            i++;
//            j--;
//        }
//        return true;
//    }
//
//    // 中序遍历数组，
//    private void dfs(node.TreeNode root){
//        // 递归退出
//        if (root == null)
//            return;
//        // 中序遍历
//        dfs(root.left);
//        roots.add(root.val);
//        dfs(root.right);
//    }
}
