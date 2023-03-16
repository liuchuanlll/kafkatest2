package leetcode;

import java.util.ArrayList;
import java.util.List;

public class day16_1回溯_最接近n数之和 {
    int sum=0;
    List<Integer> arrayInt =new ArrayList<Integer>();
    void backTracking(int[] nums,int target,int startIndex){
        if(target<toSum(arrayInt)){
            return;
        }else {
            if(sum<toSum(arrayInt)){
                sum=toSum(arrayInt);
            } else {
                return;
            }
        }

        for(int i=startIndex;i<nums.length;i++){
            arrayInt.add(nums[startIndex]);
            backTracking(nums,target,startIndex+1);
            arrayInt.remove(arrayInt.size()-1);
        }
    }

    int toSum(List<Integer> list){
        int sum=0;
        for(Integer i:list){
            sum+=i;
        }
        return sum;
    }
}



