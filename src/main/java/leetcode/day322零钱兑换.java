package leetcode;

public class day322零钱兑换 {//https://blog.csdn.net/m0_60777643/article/details/122222928
//dp[i][j]：前i+1种硬币在j金额情况下所需最少的硬币。dp[0][j]=j%v0==0？j/v0:-1    dp[i][0]=0
    // dp[1][1]=min(dp[0][1]==-1？（j%vi==0？j/v0:-1）：dp[i-1][j],dp[i][j-vi]+1）
    // 理解：若在0-max[i]中选过vi，则说明在当前剩余容量vi下是最优解。且以当前物品重量为一次循环，每次都要加

    public int coinChange(int[] coins, int amount) {
        int[][] ints = new int[coins.length - 1][amount - 1];
        return 0;
    }
}
