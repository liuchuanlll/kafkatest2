package mytest;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/17 15:17
 * @Description 一共有N种物品，每种物品有无限多个，第i（i从1开始）种物品的重量为w[i]，价值为v[i]。在总重量不超过背包承载上限W的情况下，能够装入背包的最大价值是多少？
 */
public class 背包完全_动态规划 {
//    dp[i][j]:前i种物品不超过J重量情况下的最大值(可重复放)，k为装入第i种物品的件数, k <= j/w[i]，01背包可看做k为0,1
//    二维数组推导公式：dp[i][j]=max(dp[i-1][j]  ,  dp[i-1][j-weight[i]]+value[i],  ... , dp[i-1][j-K*weight[i]]+K*value[i])
//    方法一算法略


    /**
     * 方法二
     * dp[i][j]  = max(dp[i-1][j]  ,  dp[i-1][j-w]+v,  ... ,     dp[i-1][j-(K-1)w]+(k-1)v,  dp[i-1][j-Kw]+kv)   0<=k1<=j/w
     * dp[i][j-w]= max( dp[i-1][j-w] ,dp[i-1][j-w-w]+v,  ...  , dp[i-1][j-w-k2*w]+K2*v)                         0<=k2<=j/w-1
     * 此处显然k2比k1少一个，令k2=k1-1，则
     * dp[i][j-w]= max( dp[i-1][j-w] ,dp[i-1][j-w-w]+v,  ...  , dp[i-1][j-w-(k-1)w]+(K-1)v)                     1<=k1<=j/w
     *           =max(                 dp[i-1][j-w]+v  ...                                    dp[i-1][j-Kw]+Kv      )-v
     * 第五行带入第1行，得dp[i][j]=max(dp[i-1][j] ,dp[i][j-w]+v)
     */
    public int maxValue(int[] weight,int value[],int bagSize){
        int[][] dp = new int[weight.length][bagSize+1];
        for(int i=0;i<weight.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=bagSize;j++){
            dp[0][j]=weight[0]<=j?(weight[0]/j)*j:0;
        }
        for(int i=1;i<weight.length;i++){
            for(int j=1;j<=bagSize;j++){
                dp[i][j] =j < weight[i]? dp[i-1][j]:Math.max(dp[i-1][j] , dp[i][j-weight[i]] + value[i]);
            }
        }
        return dp[weight.length-1][bagSize-1];
    }
}
