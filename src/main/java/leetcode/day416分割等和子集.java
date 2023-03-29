package leetcode;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/28 10:48
 * @Description
 */
public class day416分割等和子集 {
//    一、暴力回溯自下而上  超时
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
        if(sum==total||exist==true)
            return true;
        if(total>sum) return false;
        for(int i=index;i<nums.length;i++){
            exist = canPartition(nums, sum, total+nums[i], i + 1,exist);//此处||exist可以不要
        }
        return exist;
    }


    //    二、暴力递归自上而下 b[i][sum]=b[i-1][sum]||b[i][sum-n[i]]  超时
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
        if(remain==0) {
            return true;
        }
        boolean b = canPartition2(nums, remain, i - 1) || canPartition2(nums, remain - nums[i], i - 1);
        return b;
    }
    //    三、记忆化递归自上而下 b[i][sum]=b[i-1][sum]||b[i][sum-n[i]]  89 ms
    int exist[][];//此处不能用boolean，因为需要记录三种状态
    public boolean canPartition3(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if(sum%2!=0) return false;
        sum=sum/2;
        exist=new int[nums.length][sum+1];
        int b = canPartition3(nums, sum, nums.length-1);
        return b==1;
    }

    private int canPartition3(int[] nums, int remain, int i) {
        if(remain<0||i<0) {
            return -1;
        }
        if(remain==0) {
            return 1;
        }
        if(exist[i][remain]>0) return 1;//递归搜索多加这一句
        if(exist[i][remain]<0) return -1;//递归搜索多加这一句
        exist[i][remain]=Math.max(canPartition3(nums, remain, i-1),canPartition3(nums,remain-nums[i], i-1));
        return exist[i][remain];
    }

    //方法四动态规划：b[i][sum]=b[i-1][sum]||b[i][sum-n[i]]  33 ms
    public boolean canPartition4(int[] nums) {
        int sum=0;
        for(int n:nums){
            sum+=n;
        }
        if(sum%2!=0) return false;
        sum=sum/2;
        boolean[] b=new boolean[sum+1];
        b[0]=true;
        for(int i=0;i<nums.length;i++){
            for(int j=sum;j>0;j--){
                if(j>=nums[i]){
                    b[j]=b[j]||b[j-nums[i]];
                }
            }
        }
        return b[sum];
    }
    public static void main(String[] args) {
        day416分割等和子集 day416 = new day416分割等和子集();
        int[] nums = {1,2,5};
        boolean b = day416.canPartition4(nums);
        System.out.println(b);
    }
}
