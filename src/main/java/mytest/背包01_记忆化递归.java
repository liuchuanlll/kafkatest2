package mytest;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/14 11:22
 * @Description
 */
public class 背包01_记忆化递归 {
//    // 01背包问题：一共有 N 件物品，第 i（i 从 1 开始）件物品的重量为 w[i]，价值为 v[i]。在总重量不超过背包承载上限 W 的情况下，能够装入背包的最大价值是多少？
    int[][] memo ;
    public  int maxPrice2(int[] price ,int[] weight,int totalWeight){
        memo=new int[weight.length][totalWeight+1];
        int i = dfs2(price, weight, totalWeight, weight.length-1);
        return i;
    }

    private int dfs2(int[] price, int[] weight, int c,int index) {
        if(c <= 0 || index < 0)
            return 0;
        if(memo[index][c] != 0)
            return memo[index][c];
        int res = dfs2(weight, price, index-1, c);
        int res2=0;
        if(c >= weight[index])
             res2 = price[index] + dfs2(weight, price, index - 1, c - weight[index]);
        return memo[index][c] = Math.max(res, res2);
    }
}
