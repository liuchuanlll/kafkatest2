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
        for(int j=0;j<matrix.length;j++){
            for(int i=0;i<matrix[0].length;i++){
                if(matrix[i][j]==1){
                    int length=1;//边长
                    for(length=2;length<=Math.min(matrix[0].length-i,matrix.length-j);length++){
                        for(int cow=0;cow<length;cow++){
                            if(matrix[i+cow][j+length]!='1') break;
                        }
                        for(int col=0;col<length;col++){
                            if(matrix[i+length][j+col]!='1') break;
                        }
                        length=length-1;
                        break;
                    }
                    maxLength=Math.max(length,maxLength);
                }
            }
        }
        return maxLength;
    }
//    方法二：动态规划dp[i,j]：以i，j为右下角的正方形的最大边长 ，dp[i,j]=min(dp[i-1,j],dp[i-1,j-1],dp[i,j-1])+1
    public int maximalSquare2(char[][] matrix){
        int maxLength=0;
        int dp[][]=new int[matrix.length][matrix[0].length];
        for(int j=0;j<matrix.length;j++){
            for(int i=0;i<matrix[0].length;i++){
                if(matrix[i][j]==1){

                    maxLength=Math.max(length,maxLength);
                }
            }
        }
        return maxLength;
    }
}
