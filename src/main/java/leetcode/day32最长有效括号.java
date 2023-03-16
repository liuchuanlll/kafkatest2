package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class day32最长有效括号 {
    public int longestValidParentheses(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        int i=0;
        int max=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stack.push(ch);
            } else if(stack.size()!=0&&'('==stack.peek()){
                stack.pop();
                i+=2;
            }else {
               i=0;
            }
            max=Math.max(i,max);
        }
        return max;
    }

    public static void main(String[] args) {
        day32最长有效括号 day32 = new day32最长有效括号();
        String s = ")()())";
        int i = day32.longestValidParentheses(s);
        System.out.println(i);
    }
}
