package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static TreeNode transTreeNode(Integer[] nums){
        Queue<TreeNode> nodeList = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        nodeList.add(root);
        for(int i=1;i<nums.length;i+=2){
            TreeNode pop = nodeList.poll();
            if(nums[i]!=null){
                TreeNode left = new TreeNode(nums[i]);
                nodeList.add(left);
                pop.left=left;
            }
            if(i+1<nums.length&&nums[i+1]!=null){
                TreeNode right =new TreeNode(nums[i+1]);
                nodeList.add(right);
                pop.right=right;
            }
        }
        return root;
    }
}
public class day94二叉树的中序遍历 {
    List list=new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {

        if(root!=null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
}
