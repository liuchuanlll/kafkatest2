package leetcode;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/30 9:11
 * @Description
 */
public class day279完全平方数 {
//    1、从下到上递归 略
//    2、从上到下递归
    public int numSquares(int n){
        int i = numSquares2(n);
        return i;
    }

    private int numSquares2(int n) {
        if(n==0) return 0;
        int sqrt = (int) Math.sqrt(n);
        int amount=n;
        for(int i=sqrt;i>0;i--){
            int  i1= numSquares2(n -i*i);
            amount = Math.min(amount, i1 +1);
        }
        return amount;
    }
    //    3、从上到下记忆化递归
    int[] numSquares;
    public int numSquares3(int n){
        numSquares=new int[n+1];
        int i = numSquares4(n);
        return i;
    }

    private int numSquares4(int n) {
        if(n==0) return 0;
        if(numSquares[n]!=0) return numSquares[n];
        int sqrt = (int) Math.sqrt(n);
        int amount=n;
        for(int i=sqrt;i>0;i--){
            int  i1= numSquares4(n -i*i);
            amount = Math.min(amount, i1 +1);
        }
        return amount;
    }

    //    4、动态规划 F(n)=min(f(n-sqrt*sqrt)...f(n-1*1))+1
    private int numSquares5(int n) {
        int[] n1 = new int[n + 1];
        if(n==0) return 0;
        for(int i=1;i<=n;i++){
            n1[i]=i;
            for(int j=1;j<=(int) Math.sqrt(i);j++){
                n1[i]=Math.min(n1[i],n1[i-j*j]+1);
            }
        }
         return n1[n];

    }
    public static void main(String[] args) {
        day279完全平方数 day279 = new day279完全平方数();
        int i = day279.numSquares(12);
        System.out.println(i);
    }
}
