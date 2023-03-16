package leetcode;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2022/5/9 9:57
 * @Description
 */
public class day03无重复最长子串 {
    public int lengthOfLongestSubstring(String s) {
        LinkedList a=new LinkedList<Character>();
        int max=0;
        char[] chars=s.toCharArray();
        for(char ch:chars){
            if(!a.contains(ch)){
                a.add(ch);
            } else{
                max=Math.max(a.size(),max);
                while(a.contains(ch)){
                    a.removeFirst();
                }
                a.add(ch);
            }
        }
        return Math.max(a.size(),max);
    }
    public static void main(String[] args) {
        System.out.println(new day03无重复最长子串().lengthOfLongestSubstring("abcab"));
    }
}
