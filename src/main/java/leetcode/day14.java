package leetcode;

public class day14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int t=0;
        int count=strs.length;//字符串数组长度
        int length=strs[0].length();//第一个字符串长度
        for(int i=0;i<length;i++){//第一个数组的i列
            char a=strs[0].charAt(i);
            for(int j=1;j<count;j++){//第j个数组
                if(strs[j].length()<i+1||a!=strs[j].charAt(i)){
                    t=i;
                    i=length;
                    break;
                }
            }
        }
        return strs[0].substring(0,t);
    }

    public static void main(String[] args) {
        String s = longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(s);
    }
}
