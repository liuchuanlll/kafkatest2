package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day90回溯_子集II {
    List<List<Integer>> listList=new ArrayList<List<Integer>>();
    ArrayList<Integer> myList=new ArrayList<Integer>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return listList;
    }
    void backtracking(int[] nums,int startIndex){
        listList.add(new ArrayList<>(myList));
        if(myList.size()==nums.length){
            return;
        }
        for(int i=startIndex;i<nums.length;i++){
            if(i!=0&&i!=startIndex&&nums[i]==nums[i-1]){
                continue;
            }else{
                myList.add(nums[i]);
                backtracking(nums,i+1);
                myList.remove(myList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        day90回溯_子集II day90 = new day90回溯_子集II();
        int[] ints = {1,2,2};
        Arrays.sort(ints);
        day90.backtracking(ints, 0);
        System.out.println(day90.listList);
    }
}
