package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class day93回溯复原IP地址 {
    List<String>  ipList=new LinkedList<String>();
    List<String> resultList =new ArrayList<String>();
    public List<String> restoreIpAddresse(String s) {
       backTracking(s,0);
        return resultList;
    }

    void backTracking(String s,int startIndex){
        if(ipList.size()==4){
//            System.out.println(ipList.toString());
            if(startIndex==s.length()){
                String str="";
                for(int i=0;i<ipList.size()-1;i++){
                    str=str+ipList.get(i)+".";
                }
              str=str+ipList.get(ipList.size()-1);
                resultList.add(str);
            }
            return;
        }
        for(int i=startIndex;i<s.length();i++){
            String tempS=s.substring(startIndex,i+1);
            if(!isRange(tempS)){
                break;
            }else {
                ipList.add(tempS);
                backTracking(s,i+1);
                ipList.remove(ipList.size()-1);
            }

        }
    }

    public static void main(String[] args) {
        day93回溯复原IP地址 day93 = new day93回溯复原IP地址();
        day93.backTracking("1111",0);
        System.out.println(day93.resultList);
    }
    public boolean isRange(String sub){
        if(sub.length()!=1&&sub.charAt(0)=='0'){
            return false;
        }
        return Integer.parseInt(sub)<=255?true:false;
    }
}
