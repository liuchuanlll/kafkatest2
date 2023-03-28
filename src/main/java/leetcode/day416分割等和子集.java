package leetcode;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/28 10:48
 * @Description
 */
public class day416分割等和子集 {
//    一、暴力回溯自下而上
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if(sum%2!=0) return false;
        sum=sum/2;
        boolean b = canPartition(nums, sum, 0, 0, false);
        return b;
    }
    public boolean canPartition(int[] nums,int sum,int total,int index,boolean exist) {
        if(sum==total||exist==true) return true;
        if(total>sum) return false;
        for(int i=index;i<nums.length;i++){
            total+=nums[i];
            exist = canPartition(nums, sum, total, index + 1,exist)||exist;//此处||exist可以不要
        }
        return exist;
    }
    //    二、暴力递归自上而下 b[i][sum]=b[i-1][sum]||b[i][sum-n[i]]
    public boolean canPartition2(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if(sum%2!=0) return false;
        sum=sum/2;
        boolean b = canPartition2(nums, sum, nums.length-1);
        return b;
    }

    private boolean canPartition2(int[] nums, int remain, int i) {
        if(remain<0||i<0) {
            return false;
        }
        boolean b = canPartition2(nums, remain, i - 1) || canPartition2(nums, remain - nums[i], i - 1);
        return b;
    }

    boolean exist[][];
    public boolean canPartition3(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if(sum%2!=0) return false;
        sum=sum/2;
        exist=new boolean[nums.length][sum+1];
        boolean b = canPartition3(nums, sum, nums.length-1);
        return b;
    }

    private boolean canPartition3(int[] nums, int remain, int i) {
        if(remain<0||i<0) {
            return false;
        }
        if(exist[i][remain]==true) return true;//递归搜索多加这一句
        exist[i][remain]=canPartition3(nums, remain, i-1)||canPartition3(nums,remain-nums[i], i-1);
        return exist[i][remain];
    }
    //动态规划：b[i][sum]=b[i-1][sum]||b[i][sum-n[i]]
    public boolean canPartition4(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if(sum%2!=0) return false;
        sum=sum/2;
        boolean[][] exist2=new boolean[nums.length][sum+1];
        for(int i=0;i<)
    }
}
