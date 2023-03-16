package leetcode;

import java.util.Arrays;

public class day338比特位计数 {
    public int[] countBits(int n) {
        int[] ints = new int[n + 1];
        for(int i=1;i<=n;i++){
            int t=i;
            while(t!=0){
                ints[i]+=t&1;
                t=t>>1;
            }
        }
        return ints;
    }
//    有两种位运算思路，都是利用数组前面已经算好的数来计算当前数的1的个数
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        for(int i = 0;i<= num;i++){
            res[i] = res[i >> 1] + (i & 1);  //注意i&1需要加括号
        }
        return res;
    }
    //    偶数dp[i] = dp[i / 2]  奇数dp[i] = dp[i / 2] + 1
    public int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        for(int i = 0;i<= num;i++){
            if (i % 2 == 0)
                ans[i] = ans[i / 2];
            else
                ans[i] = ans[i / 2] + 1;
        }
        return ans;
    }
    //    7的二进制为：111 而3的二进制位：11 7-4=3 7只比3多一位
    public int[] countBits4(int num) {
        int[] res = new int[num + 1];
        if(num==0){
            return res;
        }
        for(int i=1;i<=num;i*=2){//1 2 4 8 16 32
            res[i]=1;
        }
        for(int i=2;i<num;i*=2){
            for(int j=1;j<i&&i+j<=num;j++){
                res[i+j]=res[j]+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        day338比特位计数 day338 = new day338比特位计数();
        int[] ints = day338.countBits4(10);
        System.out.println(Arrays.toString(ints));
    }
}
