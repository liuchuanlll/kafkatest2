package leetcode;

import java.util.List;

public class day236二叉树的最近公共祖先 {
    //后续遍历，全都遍历到后，下一个父节点就是返回root。
    TreeNode parentNode;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return parentNode;
    }

    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(parentNode!=null) return 2;
        if(root==null) return 0;
        int i=dfs(root.left,p,q);
        int j=dfs(root.right,p,q);
        if(root==p) i++;
        if(root==q) j++;
        if(i+j==2){
            if(parentNode==null)
                parentNode=root;
        }
        return i+j;
    }

    public static void main(String[] args) {
        Integer[] integers = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode treeNode = TreeNode.transTreeNode(integers);
        day236二叉树的最近公共祖先 day236 = new day236二叉树的最近公共祖先();
        TreeNode treeNode1 = day236.lowestCommonAncestor(treeNode, treeNode.right.left, treeNode.right.right);
        System.out.println(treeNode1.val);

    }
}
class Solution2 {
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }

    // 该函数返回false表示没有找到p或q。
    // 返回true表示找到了p或q中的任意一个。
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean l_flag = dfs(root.left, p, q);
        // 已经找到公共祖先，无需再进行dfs遍历，提前返回
        if(ans != null) return true;
        boolean r_flag = dfs(root.right, p, q);
        if(ans != null) return true;
        // 左子树、右子树分别找到p和q,公共祖先即为root
        if (l_flag && r_flag) {
            ans = root;
            return true;
        }
        //  左子树或右子树找到p或q中的一个，root是p或q中的另一个，公共祖先即为root;
        if ((l_flag || r_flag) && (root == p || root == q)) {
            ans = root;
            return true;
        }
        return l_flag || r_flag || (root == p || root == q);
    }
}