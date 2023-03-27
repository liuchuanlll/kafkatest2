package mytest;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/14 11:22
 * @Description
 */
public class 背包01_记忆化递归 {
// 01背包问题：一共有 N 件物品，第 i（i 从 1 开始）件物品的重量为 w[i]，价值为 v[i]。在总重量不超过背包承载上限 W 的情况下，能够装入背包的最大价值是多少？
    int[][] memo ;
    public  int maxPrice(int[] price ,int[] weight,int totalWeight){
        memo=new int[weight.length][totalWeight+1];
        int i = dfs(price, weight, totalWeight, weight.length-1);
        return i;
    }

    private int dfs(int[] price, int[] weight, int balance,int index) {
        if(balance <= 0 || index < 0)
            return 0;
        if(memo[index][balance] != 0)
            return memo[index][balance];
        int res = dfs(weight, price, index-1, balance);
        int res2=0;
        if(balance >= weight[index])
             res2 = price[index] + dfs(weight, price, index - 1, balance - weight[index]);
        return memo[index][balance] = Math.max(res, res2);
    }

    // 现有一笔经费可以报销一定额度的发票。要求每张发票的总额不得超过1000元，每张发票上，单项物品的价值不得超过600元。
    int[][] memo2 ;//前i件发票在balance下的最大额度
    public  int maxPrice2(int[] price ,int limit){
        memo=new int[price.length][limit+1];
        int i = dfs2(price,limit,price.length-1,limit);
        return i;
    }

    private int dfs2(int[] price, int limit, int i, int balance) {
        if(balance<=0) return 0;
        if(i<0) return 0;
        if(memo2[i][balance]!=0) return memo2[i][balance];
        int used = dfs2(price,limit,i-1,limit-price[i])+price[i];
        int notUsed=dfs2(price,limit,i-1,limit);
        memo2[i][balance]=Math.max(used,notUsed);
        return memo2[i][balance];
    }

}
