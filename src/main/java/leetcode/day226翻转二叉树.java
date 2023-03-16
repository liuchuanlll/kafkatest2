package leetcode;

public class day226翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode treeNode = new TreeNode(root.val);
        treeNode.right  = invertTree(root.left);
        treeNode.left  = invertTree(root.right);
        return treeNode;
    }
}
