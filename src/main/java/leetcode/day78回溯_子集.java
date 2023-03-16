package leetcode;

import java.util.ArrayList;
import java.util.List;

public class day78回溯_子集 {
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
            myList.add(nums[i]);
            backtracking(nums,i+1);
            myList.remove(myList.size()-1);

        }
    }

    public static void main(String[] args) {
        day78回溯_子集 day78 = new day78回溯_子集();
        day78.backtracking(new int[]{1,2,3}, 0);
        System.out.println(day78.listList);
    }
}
