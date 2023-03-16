package leetcode;

public class day100相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if((p==null&&q!=null)||(q==null&&p!=null)||p.val!=q.val) return false;

        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
