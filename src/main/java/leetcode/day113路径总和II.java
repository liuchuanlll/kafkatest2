package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day113路径总和II {
    //方法一：直接递归
    List<List<Integer>> listList=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int sum=0;
        ArrayList<Integer> list = new ArrayList<>();
        dsf(root,targetSum,sum,list);
        return listList;
    }

    private void dsf(TreeNode root, int targetSum, int sum,ArrayList<Integer> list) {
        if(root==null) return;
        sum+=root.val;
        list.add(root.val);
        if(root.left==null&&root.right==null){
            if(sum==targetSum) {
                ArrayList<Integer> list1 = new ArrayList<>(list);
                listList.add(list1);
            }
        }
        dsf(root.left, targetSum, sum, new ArrayList<>(list));
        dsf(root.right, targetSum, sum,new ArrayList<>(list));
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode treeNode = TreeNode.transTreeNode(nums);
        day113路径总和II day113 = new day113路径总和II();
        List<List<Integer>> listList = day113.pathSum(treeNode, 22);
        System.out.println(listList);
    }

}
