package leetcode;

import java.util.List;

public class day617合并二叉树 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null) return root2;
        if(root2==null) return root1;
        TreeNode node=new TreeNode();
        if(root1!=null&&root2!=null){
            node.val=root1.val+root2.val;

            TreeNode left=mergeTrees(root1.left,root2.left);
            node.left=left;

            TreeNode right=mergeTrees(root1.right,root2.right);
            node.right=right;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode root2 = new TreeNode(2);
        TreeNode treeNode = new day617合并二叉树().mergeTrees(root1, root2);
        List<Integer> integers = new day94二叉树的中序遍历().inorderTraversal(treeNode);
        System.out.println(integers);
    }
}
