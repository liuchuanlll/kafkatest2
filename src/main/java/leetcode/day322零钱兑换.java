package leetcode;

public class day322零钱兑换 {
//dp[i][j]：前i种硬币在j金额情况下所需最少的硬币。dp[i][j]=max(dp[i-1][j],dp[i][j-vi]+1)
    public int coinChange(int[] coins, int amount) {
        int[][] ints = new int[coins.length - 1][amount - 1];
        return 0;
    }
}
