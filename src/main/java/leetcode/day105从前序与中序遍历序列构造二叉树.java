package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/10 8:59
 * @Description
 */
public class day105从前序与中序遍历序列构造二叉树 {//无重复数组
    private Map<Integer, Integer> indexMap;
    int[] preorder;
    int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        this.preorder=preorder;
        this.inorder=inorder;
        return buildTree(0, n - 1, 0, n - 1);
    }

    public TreeNode buildTree(int preLeftFoot, int preRightFoot, int inLeftFoot, int inRightFoot){
        if (preLeftFoot > preRightFoot) {
            return null;
        }
        TreeNode treeNode=new TreeNode(preorder[preLeftFoot]);
        int inRootFoot=indexMap.get(preorder[preLeftFoot]);
        int leftLength=inRootFoot-inLeftFoot;
        treeNode.left=buildTree(preLeftFoot+1,preLeftFoot+leftLength,inLeftFoot,inRootFoot-1);
        treeNode.right=buildTree(preLeftFoot+leftLength+1,preRightFoot,inRootFoot+1,inRightFoot);
        return treeNode;
    }

    public static void main(String[] args) {
        day105从前序与中序遍历序列构造二叉树 solution = new day105从前序与中序遍历序列构造二叉树();
        int[] ints = {3, 9, 4, 20, 15, 7};
        int[] inorder = {4, 9, 3, 15, 20, 7};
        TreeNode treeNode = solution.buildTree(ints, inorder);
        System.out.println(treeNode);
    }
}
