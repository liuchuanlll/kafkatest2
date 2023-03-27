package leetcode;

public class day322零钱兑换 {//https://blog.csdn.net/m0_60777643/article/details/122222928
//dp[i][j]：前i+1种硬币在j金额情况下所需最少的硬币。dp[0][j]=j%v0==0？j/v0:-1    dp[i][0]=0
    // dp[1][1]=min(dp[0][1]==-1？（j%vi==0？j/v0:-1）：dp[i-1][j],dp[i][j-vi]+1）
    // 理解：若在0-max[i]中选过vi，则说明在当前剩余容量vi下是最优解。且以当前物品重量为一次循环，每次都要加

    //方法一：暴力递归
    int min=-1;
    public int coinChange(int[] coins, int amount) {
        coinChange(coins,amount,0,0);
        return min;
    }

    private void coinChange(int[] coins, int amount,long currentAmount,int currentCoinNumber) {
        if(currentAmount>amount) return;
        if(currentAmount==amount) {
            min=min==-1?currentCoinNumber:Math.min(currentCoinNumber,min);
            return;
        }
        for(int i=0;i<coins.length;i++){
            coinChange(coins,amount,currentAmount+coins[i],currentCoinNumber+1);
        }
    }
//    方法二记忆化搜索：使用数组 memo[]来保存节点的值,memo[n]表示钱币n可以被换取的最少的硬币数，不能换取就为 −1
    int memo[];
    public int coinChange2(int[] coins, int amount) {
        memo = new int[amount];
        coinChange3(coins,amount);
        return min;
    }

    private void coinChange3(int[] coins, int amount) {

    }

    public static void main(String[] args) {
        day322零钱兑换 day322 = new day322零钱兑换();
        int[] ints = {1, 2147483647};
        int i = day322.coinChange(ints, 2);
        System.out.println(i);
    }
}
