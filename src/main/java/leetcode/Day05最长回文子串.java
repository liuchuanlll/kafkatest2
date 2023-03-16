package leetcode;

public class Day05最长回文子串 {//回文的意思是正着念和倒着念一样，如：上海自来水来自海上
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] chars=s.toCharArray();
        int maxLeft=0;
        int maxRight=0;
        int maxLength=0;
        for(int i=0;i<s.length();i++){
            int left=i-1;
            int right=i+1;
            int length=0;
            while(left>=0&&chars[left]==chars[i]){
                left--;
            }
            while(right<s.length()&&chars[right]==chars[i]){
                right++;
            }
            while(left>=0&&right<s.length()&&chars[right]==chars[left]){
                left--;
                right++;
            }
            length=right-left-1;
            if(length>maxLength){
                maxLength=length;
                maxLeft=left+1;
                maxRight=right-1;
            }
        }
        return s.substring(maxLeft,maxRight+1);
    }

    public static void main(String[] args) {

        String subS = new Day05最长回文子串().longestPalindrome("babad");
        System.out.println(subS);

    }
}
