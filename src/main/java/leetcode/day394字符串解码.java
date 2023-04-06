package leetcode;

import java.util.Stack;

public class day394字符串解码 {
    public String decodeString(String s) {//3[a2[c]]
        String ans="";
        Stack<Integer> integers = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int i=0;
        while(i<s.length()){
            char c = s.charAt(i);
            if('0' <= c && c <= '9'&&i<s.length()){
                int a=0;
                while('0' <= c && c <= '9'){
                    a=a*10+c-'0';
                    c = s.charAt(++i);
                }
                integers.push(a);
            }else if(c=='['){
                c = s.charAt(++i);
                String string="";
                while(c>='a'&&c<='z'&&i<s.length()){
                    string=string+c;
                    c = s.charAt(++i);
                }
                stringStack.push(string);
            }else if(c==']'){
                i++;
                String pop = stringStack.pop();
                Integer pop1 = integers.pop();
                String s1 = ToString(pop, pop1);
                if(stringStack.empty()){
                    ans=ans+s1;
                }else{
                    stringStack.push(stringStack.pop()+s1);
                }
            }else if(c>='a'&&c<='z'){
                while(c>='a'&&c<='z'&&i<s.length()) {ans=ans+s.charAt(i);i++;}
            }
        }
        return ans;
    }
    String ToString(String s,int a){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<a;i++){
            stringBuffer.append(s);
        }
        return String.valueOf(stringBuffer);
    }
    public static void main(String[] args) {
        String s="3[a2[c]]";
        day394字符串解码 day394 = new day394字符串解码();
        String s1 = day394.decodeString(s);
        System.out.println(s1);
    }
}


