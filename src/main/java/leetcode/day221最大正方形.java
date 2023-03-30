package leetcode;

import sun.security.util.Length;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/30 10:13
 * @Description
 */
public class day221最大正方形 {
//四层循环
    public int maximalSquare(char[][] matrix){
        int maxLength=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    int length=1;//边长
                    for(length=1;length<=Math.min(matrix[0].length-j,matrix.length-i);length++){
                        int cow;
                        for(cow=0;cow<length;cow++){
                            if(matrix[i+cow][j+length-1]!='1') break;
                            if(matrix[i+length-1][j+cow]!='1') break;
                        }
                        if(cow<length){
                            break;
                        }
                    }
                    length=length-1;
                    maxLength=Math.max(length,maxLength);
                }
            }
        }
        return maxLength*maxLength;
    }
//    方法二：动态规划dp[i,j]：以i，j为右下角的正方形的最大边长 ，dp[i,j]=min(dp[i-1,j],dp[i-1,j-1],dp[i,j-1])+1
    public int maximalSquare2(char[][] matrix){
        int maxLength=0;
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='1'){
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else{
                        dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                }
                maxLength=Math.max(maxLength,dp[i][j]);
            }
        }
        return maxLength*maxLength;
    }

    public static void main(String[] args) {
        day221最大正方形 day221 = new day221最大正方形();
//        char[][] matrix = { {'0', '1'},{'1', '0'}};
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int i = day221.maximalSquare(matrix);
        System.out.println(i);
    }
}
