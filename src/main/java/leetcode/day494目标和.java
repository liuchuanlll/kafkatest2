package leetcode;

import java.util.HashMap;
import java.util.Map;

public class day494目标和 {
//    方法一暴力递归 时间538ms 击败16.49%
    public int findTargetSumWays(int[] nums, int target) {
        int targetSumWays = findTargetSumWays(nums, target, 0, 0);
        return targetSumWays;
    }

    private int findTargetSumWays(int[] nums, int remain, int index, int currentWay) {
        if(index>=nums.length) return remain==0?currentWay+1:currentWay;
        int targetSumWays = findTargetSumWays(nums, remain + nums[index], index + 1, currentWay);
        int targetSumWays2 = findTargetSumWays(nums, remain - nums[index], index + 1, currentWay);
        return targetSumWays+targetSumWays2;
    }
    //    方法二记忆化递归 SumWays[i][j]=SumWays[i-1][j-n[i-1]]+SumWays[i-1][j+n[i-1]]
    Map<Integer,Integer> SumWays;
    public int findTargetSumWays2(int[] nums, int target) {
        SumWays=new HashMap();
        int targetSumWays = findTargetSumWays2(nums, target, 0,SumWays);
        return targetSumWays;
    }

    private int findTargetSumWays2(int[] nums, int target, int index, Map<Integer,Integer> SumWays) {
        if(index>=nums.length) return SumWays.getOrDefault(target,0);
        int targetSumWays = SumWays[i-1][j-n[i-1]];
        int targetSumWays2 = findTargetSumWays2(nums, target - nums[index], index + 1, SumWays);
        return targetSumWays+targetSumWays2;
    }

    //    方法三动态规划 SumWays[i][j]=SumWays[i-1][j-n[i-1]]+SumWays[i-1][j+n[i-1]]
    public int findTargetSumWays3(int[] nums, int target) {
        Map<Integer,Integer> SumWays=new HashMap();
        Map<Integer,Integer> SumWays2=new HashMap();
        for(int i=0;i<nums.length;i++){
            SumWays=SumWays2;
            SumWays2=new HashMap();
            for(Map.Entry<Integer,Integer> entry:SumWays.entrySet()){

            }


        }
        return SumWays.getOrDefault(target,0);
    }
}
