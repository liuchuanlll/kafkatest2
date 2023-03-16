package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class day46回溯_全排列 {
    List<Integer> arrayList =new ArrayList<Integer>();
    List<List<Integer>> resList =new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] nums) {
        return null;
    }

    void backTracking(List notUse){
        if(notUse.size()==0){
            resList.add(new ArrayList<Integer>(arrayList));
            return;
        }
        for(int i=0;i<notUse.size();i++){
            arrayList.add((Integer) notUse.get(i));
            Object remove = notUse.remove(i);
            backTracking(notUse);
            arrayList.remove(arrayList.size()-1);
            notUse.add(i,remove);
        }
    }
    void backTracking(int[] nums,boolean[] used){
        if(arrayList.size()==nums.length){
            resList.add(new ArrayList<Integer>(arrayList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
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
        day46回溯_全排列 day46 = new day46回溯_全排列();
        int[] ints=new int[]{1,2,3};
        List<Integer> list1 = Arrays.stream(ints).boxed().collect(Collectors.toList());
        day46.backTracking(list1);
        System.out.println(day46.resList);

    }
}
