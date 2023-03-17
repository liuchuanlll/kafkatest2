package mytest;

public class 背包问题01_动态规划 {

// 01背包问题：一共有 N 件物品，重量为 weight[i]，价值为 value[i]。在总重量不超过背包承载上限 W 的情况下，能够装入背包的最大价值是多少？
//  dp[i][j]:前i件物品不超过J重量情况下的最大值 二维数组推导公式：dp[i][j]=max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])
    public int maxValue(int[] weight,int value[],int bagSize){
        int[][] dp = new int[weight.length][bagSize+1];
        for(int i=0;i<weight.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<bagSize;j++){
            dp[0][j]=weight[0]<=j?weight[0]:0;
        }
        for(int i=1;i<weight.length;i++){
            for(int j=1;j<=bagSize;j++){
//              当前背包的容量都没有当前物品i大的时候，是不放物品i的,那么前i-1个物品能放下的最大价值就是当前情况的最大价值
//              当前背包的容量可以放下物品i,那么此时分两种情况：1、不放物品i,2、放物品i.比较这两种情况下，哪种背包中物品的最大价值最大
                dp[i][j] =j < weight[i]? dp[i-1][j]:Math.max(dp[i-1][j] , dp[i-1][j-weight[i]] + value[i]);
            }
        }
        return dp[weight.length-1][bagSize-1];
    }
//  一维数组推导公式：dp[j]:容量为J的背包所能装的最大价值。dp[j]=max(dp[j],dp[j-w[i]]+v[i])
    public int maxValue2(int[] weight,int value[],int bagSize){
        int[] dp = new int[bagSize + 1];
        dp[0]=0;

        for(int j=1;j<bagSize;j++){

        }
        return 0;
    }
    // 现有一笔经费可以报销一定额度的发票。允许报销的发票类型包括买图书（A类）、文具（B类）、差旅（C类），要求每张发票的总额不得超过1000元，每张发票上，单项物品的价值不得超过600元。
    //发票问题：开发票有N个商品 ,每个商品价格不同,数量不同,发票固定额度为L,如何合理分配商品到每张发票,使发票的利用率达到最大

    public int maxPrice(int v[],int wNum){
        return 0;
    }


    public void DFS(int index,int v[],double sum){
//        if()

    }
}
