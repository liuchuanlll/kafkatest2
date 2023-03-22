package leetcode;

import java.util.HashMap;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/21 10:03
 * @Description
 */
public class day337打家劫舍III {
    //方法一：暴力递归：rob[root]=max(rob[root.left]+rob(root.right),root.var+rob(root.right.left)+rob(root.right.right)+rob(root.left.left)+rob(root.left.left))
    //同时由于父节点依靠子节点，所以需要后续遍历,同时类似有多个前序值求目标值的都要根据hashmap减少回溯量，否则会产生二叉树类似的指数递增计算量
//  方法二：记忆化递归，使用一个map把计算过的结果保存一下
    HashMap<TreeNode, Integer> memo  = new HashMap<>();//用父节点的最大值 rob[root]=NodeMap2[left]+NodeMap2(right)
    public int rob(TreeNode root){
        if(root==null) {return 0;}
        if (memo.containsKey(root))//已经计算过
            return memo.get(root);
        TreeNode left=root.left;
        TreeNode right=root.right;
        if(left==null) {
            if (right == null) {
                return root.val;
            } else {
                return Math.max(rob(right), root.val + rob(right.left) + rob(right.right));
            }
        }else{
            if (right == null) {
                return Math.max(rob(left), root.val + rob(left.left) + rob(left.right));
            } else {
                return Math.max(rob(left)+rob(right),root.val+rob(left.left)+rob(left.right)+rob(right.left)+rob(right.right));
            }
        }

    }
    //方法三：动态规划，f(o) 表示选择 o节点的情况，g(o) 表示不选择o节点的情况。 f(o)=g(l)+g(r)
    //当 o不被选中时，对于某个具体的孩子 x，它对 o的贡献是x被选中和不被选中情况下权值和的较大值。故g(o)=max{f(l),g(l)}+max{f(r),g(r)}
    HashMap<TreeNode, Integer> NodeMap = new HashMap<>();//用父节点的最大值 rob[root]=NodeMap2[left]+NodeMap2(right)
    HashMap<TreeNode, Integer> NodeMap2 = new HashMap<>();//不用父节点的最大值 ：rob[root]=root.var+NodeMap.[left]+NodeMap(right)
    public int rob2(TreeNode root){
        dfs(root);
        return Math.max(NodeMap.get(root),NodeMap2.get(root));
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);//先做
        dfs(node.right);//再右
        NodeMap.put(node, Math.max(node.val+NodeMap2.getOrDefault(node.left,0)+NodeMap2.getOrDefault(node.right,0),NodeMap.getOrDefault(node.left,0)+NodeMap.getOrDefault(node.right,0)));//最后父节点。用node节点
        NodeMap2.put(node,NodeMap.getOrDefault(node.left,0)+NodeMap.getOrDefault(node.right,0));
    }

    public static void main(String[] args) {
        Integer[] integers =new Integer[] {4,1,null,2,null,3};
        TreeNode root = TreeNode.transTreeNode(integers);
        day337打家劫舍III day337 = new day337打家劫舍III();
        int rob = day337.rob2(root);
        System.out.println(rob);
    }




}
