package leetcode;

public class day309最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        //记录买卖持有二种状态下的最大收益 dp[i][0]持有现金， dp[i][1]：持有股票
        //dp[i][0]=max(dp[i-1][0], dp[i-1][1] + prices[i])  昨天就持有现金，今天不做操作||昨天持有今天卖掉了
        //dp[i][1]=max(dp[i-1][1], dp[i-2][0] - prices[i])  昨天就持有股票，今天不做操作||（今天买入且昨天最少空闲一天）=昨天就持有股票，今天不做操作||（今天买入且前天持有现金）
        int[][] profit = new int[prices.length][2];
        profit[0][0]=0;
        profit[0][1]=-prices[0];
        for(int i=1;i<prices.length;i++){
            profit[i][0]=Math.max(profit[i-1][0], profit[i-1][1] + prices[i]);
            profit[i][1]=Math.max(profit[i-1][1], (i==1?profit[i-1][0]:profit[i-2][0]) - prices[i]);
        }
        return profit[prices.length-1][0];
    }

    //记录买卖持有三种状态下的最大收益 dp[i][0]持有现金非冷冻期，dp[i][1]：持有股票 dp[i][2]：持有现金冷却期
    //dp[i][0]=max(dp[i-1][0],dp[i-1][1])  昨天就持有现金且非冷冻期||昨天冷冻期
    //dp[i][1]=max(dp[i-1][1], dp[i−1][0]−prices[i])  昨天就持有股票，今天不做操作||昨天非冷冻期，今天买入
    //dp[i][1]=dp[i−1][0]+prices[i]


//    vector<vector<int>>dp(prices.size(),vector<int>(4));
//    dp[0][0]=0;//不持有股票，没卖出的
//    dp[0][1]=0;//不持有股票，卖出去了
//    dp[0][2]=-1*prices[0];//持有股票，今天买入；
//    dp[0][3]=-1*prices[0];//持有股票，非今天买入的；
//    for(int i=1;i<prices.size();i++){
//        dp[i][0]=max(dp[i-1][0],dp[i-1][1]);//前一天不持有股票的两种情况的最大值
//        dp[i][1]=max(dp[i-1][2],dp[i-1][3])+prices[i];//今天卖出股票，来着前一天持有股票的最大值+pr
//        dp[i][2]=dp[i-1][0]-prices[i];//今天买入股票，这前一天一定没有卖出股票
//        dp[i][3]=max(dp[i-1][2],dp[i-1][3]);//今天没买股票，却持有股票，前一天继承来的,有两种情况
//    }
//    return max(dp[prices.size()-1][0],dp[prices.size()-1][1]);

    public static void main(String[] args) {
        day309最佳买卖股票时机含冷冻期 day309 = new day309最佳买卖股票时机含冷冻期();
        int[] prices = {1,2,4};
        int i = day309.maxProfit(prices);
        System.out.println(i);
    }
}
