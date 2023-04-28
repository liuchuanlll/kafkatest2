package base;


import java.util.*;

public class 二叉树非递归遍历 {
    //前序遍历先处理根节点，然后根据左右子节点的反序入栈
    public List<Integer> preorderTraversal( TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Stack<TreeNode> intSt = new Stack<>();
        intSt.push(root);
        while(!intSt.empty()){
            TreeNode pop = intSt.pop();
            if(pop.right!=null) intSt.push(pop.right);
            if(pop.left!=null) intSt.push(pop.left);
            result.add(pop.val);
        }
        return result;
    }

    //中序遍历先按照左中的反序中左入栈，然后处理右节点
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> intSt = new Stack<>();
        TreeNode curr=root;
        while(!intSt.empty()||curr!=null){
            while(curr!=null){
                intSt.push(curr);
                curr=curr.left;
            }
            if(!intSt.empty()) {
                TreeNode pop = intSt.pop();
                result.add(pop.val);
                curr=pop.right;
            }
        }
        return result;
    }

    //后序遍历顺序1: 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果。但这种做法虽然得到了正确结果，却违反了后续遍历的初衷
//后序遍历顺序2：
    // 和中序不同的是，中序遍历中，从栈中弹出的节点其左子树访问完了，可以直接访问该节点。
    // 而后续遍历中，从栈中弹出的节点，我们只能判断左子树访问完了，无法确定右子树访问过，因此我们在后续遍历中引入一个prev记录历史访问记录
    //当访问完子树的时候我们用prev指向该节点，这样在回溯到父节点的时候，我们可以根据prev的指向判断父节点的访问情况
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> intSt = new Stack<>();//栈顶为curr的父节点
        TreeNode prev=null;//上一个处理的右节点，
        TreeNode curr=root;//当前活动节点
        while(!intSt.empty()||curr!=null){
            while(curr!=null){
                intSt.push(curr);
                curr=curr.left;
            }
            TreeNode pop = intSt.pop();

            if(pop.right==prev||pop.right==null){//prev指向右子树
                result.add(pop.val);
                prev=pop;//prev指向右子树
            }else{
                intSt.push(pop);
                curr=pop.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.transTreeNode(new Integer[]{1, 2, 3,null,6});
        二叉树非递归遍历 二叉树非递归遍历 = new 二叉树非递归遍历();
        List<Integer> integers = 二叉树非递归遍历.postorderTraversal(treeNode);
        System.out.println(integers);
    }
}
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