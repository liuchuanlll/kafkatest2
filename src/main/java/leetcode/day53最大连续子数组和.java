package leetcode;

public class day53最大连续子数组和 {

//   动态规划 dp[i]=max{nums[i],dp[i−1]+nums[i]}
    public int maxSubArray(int[] nums) {
        int[] ints = new int[nums.length];
        ints[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(ints[i-1]>0){
                ints[i]=ints[i-1]+nums[i];
            }else {
                ints[i]=nums[i];
            }
        }
        int res = ints[0];
        for (int i = 1; i < ints.length; i++) {
            res = Math.max(res, ints[i]);
        }
        return res;
    }
}
