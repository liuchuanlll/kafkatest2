package leetcode;

import java.util.ArrayList;
import java.util.List;

public class day437路径总和III {
    //解法一，双层暴力递归
    int i;
    public int pathSum(TreeNode root, int targetSum) {
        long sum=0;
        if(root==null) return 0;
        dsf(root,targetSum,sum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return i;
    }

    private void dsf(TreeNode root, int targetSum, long sum) {
        if(root==null) return;
        sum+=root.val;
        if(sum==targetSum)
            i++;

        dsf(root.left, targetSum, sum);
        dsf(root.right, targetSum, sum);
    }
    //解法二，一层递归+前缀和，用数组记录从根节点到本节点的值，计算以本节点为结尾的符合条件的连续子数组（无后效性）
    int i2;
    public int pathSum2(TreeNode root, int targetSum) {
        long sum=0;
        if(root==null) return 0;
        dsf2(root,targetSum,sum);
        return i;
    }

    private void dsf2(TreeNode root, int targetSum, long sum) {
        if(root==null) return;
        sum+=root.val;
        if(sum==targetSum)
            i2++;
        dsf(root.left, targetSum, sum);
        dsf(root.right, targetSum, sum);
    }
    public static void main(String[] args) {
        Integer[] nums = {1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000};
        TreeNode treeNode = TreeNode.transTreeNode(nums);
        day437路径总和III day437 = new day437路径总和III();
        int i = day437.pathSum(treeNode, 0);
        System.out.println(i);
    }

}
