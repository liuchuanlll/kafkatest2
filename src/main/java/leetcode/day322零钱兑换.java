package leetcode;

public class day322零钱兑换 {//https://blog.csdn.net/m0_60777643/article/details/122222928


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
//    方法二记忆化搜索
    int memo[];//memo[j]表示钱币可以在j额度被换取的最少的硬币数，不能换取就为 −1。F(s)=min( F(s-c1),F(s-c2),F(s-c3))+1
    public int coinChange2(int[] coins, int amount) {
        memo = new int[amount+1];
        int i = coinChange3(coins, amount);
        return i;
    }

    private int coinChange3(int[] coins, int amount) {
        if(amount==0) return 0;
        if(amount<0) return -1;
        if(memo[amount]!=0){
            return memo[amount];
        }
        int min=-1;
        for(int i=0;i<coins.length;i++){
            int res = coinChange3(coins, amount - coins[i]);
            int res2=res==-1?-1:res+1;
            min=min==-1?res2:res==-1?min:Math.min(min, res2);//min等于（-1，普通值）*（re2s=-1，普通值）四类
        }
        return memo[amount]=min;
    }
    //方法三动态规划：F(s)=min( F(s-c1),F(s-c2),F(s-c3))+1
    public int coinChange4(int[] coins, int amount) {
        int[] ints = new int[amount+1];
        ints[0]=0;
        for(int i=1;i<amount+1;i++){
            int min=-1;
            for(int j=0;j<coins.length;j++){
                int fs_ci=i<coins[j]||ints[i-coins[j]]==-1?-1:ints[i-coins[j]]+1;
                min=min==-1?fs_ci:fs_ci==-1?min:Math.min(min,fs_ci);
            }
            ints[i]=min;
        }
        return ints[amount];
    }


    public static void main(String[] args) {
        day322零钱兑换 day322 = new day322零钱兑换();
        int[] ints = {2};
        int i = day322.coinChange4(ints, 3);
        System.out.println(i);
    }
}
