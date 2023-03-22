package leetcode;

public class day112路径总和 {
    //方法一：直接递归
    boolean exist;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum=0;
        dsf(root,targetSum,sum);
        return exist;
    }

    private int dsf(TreeNode root, int targetSum, int sum) {
        if(root==null||exist==true) return 0;
        sum+=root.val;
        if(root.left==null&&root.right==null){
            if(sum==targetSum)
                exist=true;
        }
        int dsf = dsf(root.left, targetSum, sum);
        int dsf1 = dsf(root.right, targetSum, sum);
        return 0;
    }
    private void dsf2(TreeNode root, int targetSum, int sum) {
        if(root==null||exist==true) return;
        sum+=root.val;
        if(root.left==null&&root.right==null){
            if(sum==targetSum)
                exist=true;
        }
        dsf2(root.left, targetSum, sum);
        dsf2(root.right, targetSum, sum);
    }
    //方法二：类似回溯。递归无sum参数
    int sum=0;
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        dsf3(root,targetSum);
        return exist;
    }

    private void dsf3(TreeNode root, int targetSum) {
        if(root==null||exist==true) return;
        sum+=root.val;
        if(root.left==null&&root.right==null){
            if(sum==targetSum) {
                exist=true;
                return;
            }
        }
        dsf(root.left, targetSum, sum);
        dsf(root.right, targetSum, sum);
        sum-=root.val;
    }

}
