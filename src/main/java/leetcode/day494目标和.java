package leetcode;

import java.util.HashMap;
import java.util.Map;

public class day494目标和 {
//    方法一暴力递归 时间538ms 击败16.49%
    public int findTargetSumWays(int[] nums, int target) {
        int targetSumWays = findTargetSumWays(nums, target, 0, 0);
//        int targetSumWays = findTargetSumWays(nums, target, nums.length-1, 0);//或者
        return targetSumWays;
    }

    private int findTargetSumWays(int[] nums, int remain, int index, int currentWay) {
        if(index>=nums.length) return remain==0?currentWay+1:currentWay;
//        if(index<0) return remain==0?currentWay+1:currentWay;
        int targetSumWays = findTargetSumWays(nums, remain + nums[index], index + 1, currentWay);//index - 1
        int targetSumWays2 = findTargetSumWays(nums, remain - nums[index], index + 1, currentWay);//index - 1
        return targetSumWays+targetSumWays2;
    }
//        方法二记忆化递归 SumWays[i][j]=SumWays[i-1][j-n[i-1]]+SumWays[i-1][j+n[i-1]]
    Map<Integer,Integer>[] SumWaysArr;
    public int findTargetSumWays2(int[] nums, int target) {
        SumWaysArr=new HashMap[nums.length];
        int targetSumWays = findTargetSumWays2(nums, target, nums.length-1);
        return targetSumWays;
    }

    private int findTargetSumWays2(int[] nums, int remain, int index) {
        if(index<0) return remain==0?1:0;
        if(SumWaysArr[index]==null) SumWaysArr[index]=new HashMap();
        if(SumWaysArr[index].get(remain)==null){
            int targetSumWays = findTargetSumWays2(nums, remain + nums[index], index - 1);
            int targetSumWays2 = findTargetSumWays2(nums, remain - nums[index], index - 1);
            SumWaysArr[index].put(remain,targetSumWays+targetSumWays2);
        }
        return SumWaysArr[index].get(remain);
    }
    // 方法三bfs宽度优先递归 SumWays[i][j]=SumWays[i-1][j-n[i-1]]+SumWays[i-1][j+n[i-1]]
    public int findTargetSumWays3(int[] nums, int target) {
        Map<Integer,Integer> SumWays=new HashMap();
        SumWays.put(target,1);
        int targetSumWays = findTargetSumWays3(nums, target, nums.length-1,SumWays);
        return targetSumWays;
    }

    private int findTargetSumWays3(int[] nums, int remain, int index,Map<Integer,Integer> SumWays) {
        if(index<0) return SumWays.getOrDefault(0,0);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry:SumWays.entrySet()){
            int key1 = entry.getKey() + nums[index];
            int key2 = entry.getKey() - nums[index];
            hashMap.put(key1,hashMap.getOrDefault(key1, 0) + entry.getValue());
            hashMap.put(key2,hashMap.getOrDefault(key2, 0) + entry.getValue());
        }
        int targetSumWays3 = findTargetSumWays3(nums, remain, index - 1, hashMap);
        return targetSumWays3;
    }
//    方法四：根据方法三递归改造成循环
    public int findTargetSumWays4(int[] nums, int target) {
        Map<Integer,Integer> SumWays=new HashMap();
        SumWays.put(target,1);
        for(int i=nums.length-1;i>=0;i--){
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for(Map.Entry<Integer,Integer> entry:SumWays.entrySet()){
                int key1 = entry.getKey() + nums[i];
                int key2 = entry.getKey() - nums[i];
                hashMap.put(key1,hashMap.getOrDefault(key1, 0) + entry.getValue());
                hashMap.put(key2,hashMap.getOrDefault(key2, 0) + entry.getValue());
            }
            SumWays=hashMap;
        }
        return SumWays.getOrDefault(0,0);
    }
    //方法五：动态规划 SumWays[i][j]=SumWays[i-1][j-n[i]]+SumWays[i-1][j+n[i]],中间结果的范围为 [−s,s],整体右移S后SumWays[i][j+s]=SumWays[i-1][j-n[i]+s]+SumWays[i-1][j+n[i]+s]
    public int findTargetSumWays5(int[] nums, int target) {
        int n = nums.length;
        int s = 0;
        for (int i : nums) s += Math.abs(i);
        if (Math.abs(target) > s) return 0;
        int[][] f = new int[n][2 * s + 1];
        f[0][nums[0] + s] = 1;
        f[0][-nums[0] + s] += 1;
        for (int i = 1; i < n; i++) {
            for (int j = -s; j <= s; j++) {
                if(j > s-Math.abs(nums[i])) f[i][j + s] = f[i - 1][(j - nums[i]) + s];
                else if(j<-s+Math.abs(nums[i])) f[i][j + s] = f[i - 1][(j + nums[i]) + s];
                else f[i][j + s] = f[i - 1][(j - nums[i]) + s]+f[i - 1][(j + nums[i]) + s];
            }
        }
        return f[n-1][target + s];
    }
    //方法刘：动态规划01背包，找到一个子集P，使得sum(P)= (target+sum(nums))/2
    public int findTargetSumWays6(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int sums = 0;
        for (int num : nums) sums += num;
        if (sums < Math.abs(target) || (target + sums) % 2 == 1) return 0;
        int p = (target + sums) / 2;
        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = p; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[p];
    }
    public static void main(String[] args) {
        day494目标和 day494 = new day494目标和();
        int[] ints = {0,1};
        int targetSumWays3 = day494.findTargetSumWays5(ints, 1);
        System.out.println(targetSumWays3);
    }
}
