package leetcode;

public class day114 {
    public void flatten(TreeNode root) {
        TreeNode pre=root;
        while(root!=null) {
            if(root.left!=null){
                TreeNode left=root.left;
                while (left.right!=null){
                    left=left.right;
                }
                left.right=root.right;
                root.left=null;
                root=root.right;
            }
        }

    }
}
