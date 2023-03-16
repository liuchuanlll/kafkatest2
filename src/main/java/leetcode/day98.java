package leetcode;

public class day98 {
    Integer pre;
    public boolean isValidBST(TreeNode root) {
        // 最小值初始化为中序序列的第一个节点值

        if(root==null){return true;}

        boolean l=isValidBST(root.left);
        if(pre!=null&&root.val<=pre) return false;
        pre = root.val;
        boolean r=isValidBST(root.right);

        return l && r;
    }

}
