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
    public int maxProfit2(int[] prices) {

        return 0;
    }
}
