package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day216回溯_组合总和III {
    List<Integer> arrayList =new ArrayList<Integer>();
    List<List<Integer>> resList =new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int num, int target) {
        backTracking(num,target,1);
        return this.resList;
    }
    void backTracking(int num,int t,int startIndex){
        if(toSum(arrayList)>=t||arrayList.size()>=num){
            if(num==arrayList.size()&&t==toSum(arrayList)){
                ArrayList<Integer> tempList=new ArrayList<Integer>(arrayList);
                resList.add(tempList);
            }
            return;
        }
        for(int i=startIndex;i<=9;i++){
                arrayList.add(i);
                backTracking(num,t,i+1);
                arrayList.remove(arrayList.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new day216回溯_组合总和III().combinationSum3(3, 9);//个数为3个，总和为9
        System.out.println(lists);
    }
    static int toSum(List<Integer> arrayList){
        int sum=0;
        for(Integer i:arrayList){
            sum+=i;
        }
        return sum;
    }
}
