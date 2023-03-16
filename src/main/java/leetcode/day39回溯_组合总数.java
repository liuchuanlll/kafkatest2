package leetcode;

import java.util.ArrayList;
import java.util.List;

public class day39回溯_组合总数 {
    List<Integer> arrayList =new ArrayList<Integer>();
    List<List<Integer>> resList =new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTracking(candidates,target,0);
        return this.resList;
    }
    void backTracking(int[] ints,int t,int startIndex){
        if(t<=toSum(arrayList)){
            if(t==toSum(arrayList)){
                ArrayList<Integer> tempList=new ArrayList<Integer>(arrayList);
                resList.add(tempList);
            }
            return;
        }
        for(int i=startIndex;i<ints.length;i++){
            arrayList.add(ints[i]);
            backTracking(ints,t,i);
            arrayList.remove(arrayList.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new day39回溯_组合总数().combinationSum(new int[]{2, 3, 6, 7}, 7);
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
