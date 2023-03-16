package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day40回溯_组合总数II {
    List<Integer> arrayList =new ArrayList<Integer>();
    List<List<Integer>> resList =new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if(i!=0&&ints[i]==ints[i-1]&&i!=startIndex){//i=startindex时说明该数组在本轮（层）循环中被首次使用
                continue;
            }else{
                arrayList.add(ints[i]);
                backTracking(ints,t,i+1);
                arrayList.remove(arrayList.size()-1);
            }

        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new day40回溯_组合总数II().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
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
