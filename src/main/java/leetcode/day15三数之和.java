package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList=new ArrayList<>();
        if(nums.length<3) return resultList;
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        int length=nums.length;
        for(int i=0;i<length-2;i++){
//            System.out.println(nums[i]);
            if(nums[i]>0) break;
            int left=i+1;
            int right=length-1;
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            while(left<right){//[-14,-3,17],[-14,1,13],[-14,2,12]
                if(nums[i]+nums[left]+nums[right]==0){
                    List<Integer> myList=Arrays.asList(nums[i],nums[left],nums[right]);
                    resultList.add(myList);
                    while(left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while(left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                } else if(nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }
            }

        }
        return resultList;
    }

    public static void main(String[] args) {
      int[] b= new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = new day15三数之和().threeSum(b);
        System.out.println(lists);
    }
}
