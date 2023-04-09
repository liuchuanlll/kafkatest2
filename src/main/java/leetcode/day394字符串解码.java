package leetcode;

import java.util.Stack;

public class day394字符串解码 {//[前面肯定有数字,数字前面一定有字符串或“”，字符串前面一定有[或]
    //1、如果是数字,将数字转成整型数字等待处理//2、如果是字符 将字符添加到当前临时字符串中//3、如果是'['  将当前数字和临时字符串添加到各自栈中
    //4、如果是']'  将数字和字符栈各取出加上[]内的字符串，然后拼接成新的临时字符串。
    public String decodeString(String s) {//3[a2[c]2[d]] 3[a]2[bc]  "3[z]2[2[y]pq4[2[jk]e1[f]]]ef"  abc3[cd]xyz
        String ans="";
        Stack<Integer> integers = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        int i=0;
        StringBuilder temp = new StringBuilder();
        int a=0;
        while(i<s.length()){
            char c = s.charAt(i++);
            if(c>='a'&&c<='z'){
                temp.append(c);
            }else if('0' <= c && c <= '9'){
                a=a*10+c-'0';
            }else if(c=='['){
                integers.push(a);
                stringStack.push(temp);
                a=0;
                temp = new StringBuilder();
            }else if(c==']'){
                Integer pop1 = integers.pop();
                StringBuilder pop = stringStack.pop();
                temp = pop.append(ToString(temp, pop1));
                if(integers.empty()){
                    ans=ans+temp;
                    temp= new StringBuilder();
                }
            }
        }
        return ans+temp;
    }
    String ToString(StringBuilder s,int a){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<a;i++){
            stringBuffer.append(s);
        }
        return String.valueOf(stringBuffer);
    }
    //递归
    public String decodeString2(String s) {//3[a2[c]]   "3[z]2[2[y]pq4[2[jk]e1[f]]]ef"  abc3[cd]xyz
        String ans="";
        for(int i=0;i<s.length();i++){

        }
        return  ans;
    }
    public static void main(String[] args) {
        String s="3[a2[c]2[d]]";
        day394字符串解码 day394 = new day394字符串解码();
        String s1 = day394.decodeString(s);
        System.out.println(s1);
    }
}


