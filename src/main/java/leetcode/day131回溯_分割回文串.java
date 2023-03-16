package leetcode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class day131回溯_分割回文串 {
    List<String> arrayList =new LinkedList<String>();
    List<List<String>> resList =new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return resList;
    }

    void backTracking(String s,int startIndex){
       if(startIndex==s.length()){
//           System.out.println(arrayList);
           List<String> tempList =new ArrayList<String>(arrayList);
           resList.add(tempList);
           return;
       }
       for(int i=startIndex;i<s.length();i++){
           String subString=s.substring(startIndex,i+1);
           if(isFlag(subString)){
               arrayList.add(subString);
               backTracking(s,i+1);
               arrayList.remove(arrayList.size()-1);
           }else {
               continue;
           }
       }
    }
    // 判断此区间内的字符串是否为 回文子串
    private boolean isFlag(String str){
        char[] s=str.toCharArray();
        int begin=0;
        int end=s.length-1;
        while(begin < end){
            if(s[begin] != s[end]){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
//        String substring = "12".substring(0,1);
//        System.out.println(substring);//结果：1 左闭右开
        day131回溯_分割回文串 day131 = new day131回溯_分割回文串();
        day131.backTracking("cbbbcc",0);
        System.out.println(day131.resList.toString());
    }
}
