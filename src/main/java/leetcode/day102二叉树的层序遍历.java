package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class day102二叉树的层序遍历 {



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retOrder = new LinkedList<>();
        LinkedList list=new LinkedList<TreeNode>();
        list.add(root);
        while(!list.isEmpty()){
            int length=list.size();
            List<Integer> singleOrder=new ArrayList<Integer>();
            for(int i=0;i<length;i++){
                TreeNode first = (TreeNode) list.getFirst();
                singleOrder.add(first.val);
                TreeNode myTreeNode =(TreeNode) list.remove();
                if(myTreeNode.left!=null) list.add(myTreeNode.left);
                if(myTreeNode.right!=null) list.add(myTreeNode.right);
            }
            retOrder.add(singleOrder);
        }
        return retOrder;
    }

}
