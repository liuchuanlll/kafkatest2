package leetcode;

import java.util.Stack;

public class day394字符串解码 {
    public String decodeString(String s) {//3[a2[c]]
        Stack<Integer> integers = new Stack<>();
        Stack<String> string = new Stack<>();
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if('0' <= c && c <= '9'){
                integers.push(c-'0');
            }else if(c=='['){
                characters.push(c);
            }else if(c==']'){

            }else if(c>='a'&&c<='z'){
                while(c>='a'&&c<='z') string=s
            }
        }
        return "";
    }

    public static void main(String[] args) {

    }
}


