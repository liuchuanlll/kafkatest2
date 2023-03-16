package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day22括号生成 {
    //()
    //()()  (()) ()()剔除
    //()()() (())() ()()()剔除 ()(()) ((()))
//    使用一个变量 balance表示左括号的数量减去右括号的数量。如果在遍历过程中 balance 的值小于零，或者结束时 balance的值不为零，那么该序列就是无效的，否则它是有效的。
//    只要还有剩余可选的左括号，就可以选左括号。只有当剩余可选的右括号 > 剩余可选的左括号 时，才可选右括号
    //一句话总结：剩余左括号总数要小于等于右括号
    List<String> myList=new ArrayList<String>();
    StringBuffer stringBuffer=new StringBuffer();

    public List<String> generateParenthesis(int n) {
        return null;
    }
    void backTracking(int n,int left,int right){
        if(left<right||left>n||right>n)
            return;
        if(left==n&&right==n) {
            myList.add(stringBuffer.toString());
            return;
        }
        for(int i=0;i<2;i++){
            if(i==0){
                stringBuffer.append('(');
                backTracking(n,left+1,right);
            } else if(i==1){
                stringBuffer.append(')');
                backTracking(n,left,right+1);
            }
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
    }

    public static void main(String[] args) {
        day22括号生成 day22 = new day22括号生成();
        day22.backTracking(3,0,0);
        System.out.println(day22.myList);
    }
}
