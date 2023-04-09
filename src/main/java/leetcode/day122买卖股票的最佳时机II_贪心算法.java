package leetcode;

public class day122买卖股票的最佳时机II_贪心算法 {
//    贪心算法
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int res = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }
    //动态规划dp[i][0]持有现金， dp[i][1]：持有股票
//    dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);  按照昨天什么都不做，昨天卖掉了
//    dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);  按照昨天什么都不做，昨天买入掉了
    public int maxProfit2(int[] prices) {

        return 0;
    }
}
