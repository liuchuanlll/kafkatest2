package leetcode;

import java.util.List;

public class day538把二叉搜索树转换为累加树 {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
//从后面的中续遍历，然后累加
        dfs(root);
        return root;

    }

    private void dfs(TreeNode root) {
        if(root==null) return;
        dfs(root.right);
        sum=sum+root.val;
        root.val=sum;
        dfs(root.left);
    }

    public static void main(String[] args) {
        Integer[] integers = {0,null,1};
        TreeNode treeNode = TreeNode.transTreeNode(integers);
        day538把二叉搜索树转换为累加树 day538 = new day538把二叉搜索树转换为累加树();
        TreeNode treeNode1 = day538.convertBST(treeNode);
        List<List<Integer>> lists = new day102二叉树的层序遍历().levelOrder(treeNode1);
        System.out.println(lists);

    }
}
