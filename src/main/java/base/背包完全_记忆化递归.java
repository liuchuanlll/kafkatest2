package base;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/14 11:22
 * @Description
 */
public class 背包完全_记忆化递归 {
// 01背包问题：一共有N种物品，重量为w[i]，价值为v[i]。在总重量不超过背包承载上限 W 的情况下，能够装入背包的最大价值是多少？
    int[] memo ;
    public  int maxPrice(int[] v ,int[] weight,int totalWeight){
        memo=new int[totalWeight+1];
        int i = dfs(v, weight, totalWeight);
        return i;
    }

    private int dfs(int[] v, int[] weight, int balance) {
        if(balance <= 0 )
            return 0;
        if(memo[balance] != 0)
            return memo[balance];
        int maxRes=0;
        for(int i=0;i<weight.length;i++){
            if(weight[i]<=balance){
                int res=dfs(v,weight,balance-weight[i])+v[i];
                maxRes=Math.max(maxRes,res);
            }
        }
        return memo[balance] = maxRes;
    }

    // 现有一笔经费可以报销一定额度的发票。要求每张发票的总额不得超过1000元，每张发票上，单项物品的价值不得超过600元。
    int[] memo2 ;//前i件发票在balance下的最大额度
    public  int maxPrice2(int[] price ,int limit){
        memo=new int[limit+1];
        int i = dfs2(price,limit,limit);
        return i;
    }

    private int dfs2(int[] price, int limit, int balance) {
        if(balance<=0) return 0;
        if(memo2[balance]!=0) return memo2[balance];
        int maxRes=0;
        for(int i=0;i<price.length;i++){
            if(price[i]<=balance){
                int res=dfs2(price,limit,balance-price[i])+price[i];
                maxRes=Math.max(maxRes,res);
            }
        }
        return memo[balance] = maxRes;
    }

}
