package leetcode;

public class day28找出字符串中第一个匹配项的下标 {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()) return -1;
        for(int i=0;i<haystack.length()-needle.length();i++){
            for(int j=0,k=0;j+i<haystack.length();k++,j++) {
                if (haystack.charAt(i + j) != needle.charAt(k)) {
                    break;
                } else{
                    if(k==needle.length()-1){
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        day28找出字符串中第一个匹配项的下标 day28 = new day28找出字符串中第一个匹配项的下标();
        day28.strStr("mississippi","issipi");
    }
}
