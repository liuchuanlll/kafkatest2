package leetcode;

public class day647回文子串 {
//    动态规划 f(s)=f(s-1)+以n[s]结尾的数
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int sum=0;
        for(int i=0;i<s.length();i++){
           for(int j=i;j>=0;j--){
               if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j+ 1])){
                   dp[i][j] = true;
                   sum++;
               }
           }
        }
        return sum;
    }
//2. 中心扩展法
    public int countSubstrings2(String s) {
        int num = 0;
        int n = s.length();
        for(int i=0;i<n;i++)//遍历回文中心点
        {
            for(int j=0;j<=1;j++)//j=0,中心是一个点，j=1,中心是两个点
            {
                int l = i;
                int r = i+j;
                while(l>=0 && r<n && s.charAt(l--)==s.charAt(r++))
                    num++;
            }
        }
        return num;
    }

}
