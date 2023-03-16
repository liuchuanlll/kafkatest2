package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class day47回溯_全排列II {
    List<Integer> arrayList =new ArrayList<Integer>();
    List<List<Integer>> resList =new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        return null;
    }

    void backTracking(int[] nums,boolean[] used){
        if(arrayList.size()==nums.length){
            resList.add(new ArrayList<Integer>(arrayList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            } else if(i!=0&&nums[i]==nums[i-1]&&used[i-1]){
                continue;
            } else{
                arrayList.add(nums[i]);
                used[i]=true;
                backTracking(nums,used);
                arrayList.remove(arrayList.size()-1);
                used[i]=false;
            }
        }
    }
    public static void main(String[] args) {
        day47回溯_全排列II day47 = new day47回溯_全排列II();
        int[] nums=new int[]{1,2,2,3};
        Arrays.sort(nums);
        day47.backTracking(nums,new boolean[nums.length]);
        System.out.println(day47.resList);

    }
}
