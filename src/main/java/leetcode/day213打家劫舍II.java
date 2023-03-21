package leetcode;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/21 8:57
 * @Description
 */
public class day213打家劫舍II {
//    dp[i]:前i个房屋能偷到的最高金额 dp[i]=max(dp[i-1],dp[i-2]+n[i]) 0<i<=j-1
//    dp[i]=max(dp[i-1],dp[i-2]+boolean*nums[i])  i=j
    public int rob(int[] nums){
        int[] dp=new int[nums.length];
        //不用最后一个
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length-1;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        int maxNotUsedI=dp[nums.length-2];
        //用最后一个
        dp[0]=0;
        dp[1]=nums[1];
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return Math.max(maxNotUsedI,dp[nums.length-1]);
    }
}
