package other;

import java.util.Stack;

public class 招商银行exam {
    public static boolean magicString (String s) {
        // write code here用栈的知识操作

        Stack stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if('c'==s.charAt(i)){
                stack.push(s.charAt(i));
            }else if(stack.empty()){
                return  false;
            }else {
                Object pop = stack.pop();
            }
        }
        return stack.empty();
    }
    public static int validNum (int N) {
        // write code here  动态规划或者这递归 F(n)=M(n)+c(n);M(n)=C(n-1)+M(n-1)  C(n)=M(n-1)

        int C[]=new int[N+1];
        int M[]=new int[N+1];
        C[0]=0;M[0]=0;
        C[1]=1;M[1]=1;
        for(int i=2;i<=N;i++){
            C[i]=M[i-1];
            M[i]=C[i-1]+M[i-1];
        }
        return C[N]+M[N];
    }
    public static void main(String[] args) {

        boolean bo = magicString("cmccmcmcmcmmccmmccccmccmcmccmmcmcccmmmmmmmm");
        int i = validNum(3);
        System.out.println(i);
    }


}
