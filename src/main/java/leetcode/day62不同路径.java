package leetcode;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

public class day62不同路径 {
    //动态规划  dp[i][j]=dp[i-1][j]+dp[i][j-1] dp[i][0]=1  dp[0][j]=1
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        day62不同路径 day62 = new day62不同路径();
        int i = day62.uniquePaths(50, 9);
        System.out.println(i);
    }
}
