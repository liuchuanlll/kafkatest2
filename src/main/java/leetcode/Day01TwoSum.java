package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Day01TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map a=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(a.containsKey(target-nums[i])){
                return new int[]{i, (int)a.get(target-nums[i])};
            }
            a.put(nums[i],i);
        }
        return null;
    }
}