package leetcode;

import java.util.Arrays;

public class day300最长递增子序列 {
//    方法一从前往后回溯 略
//    方法二动态规划f(i):以第i个数字结尾的最大递增子序列。f(i)=max(f(1)+1,f(2)+1....f(j)+1) 当n(i)>n(j)时
    public int lengthOfLIS(int[] nums) {
        int[] ints = new int[nums.length];
        Arrays.fill(ints, 1);
        int max=ints[0];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    ints[i]=Math.max(ints[i],ints[j]+1);
                }
            }
            max=Math.max(max,ints[i]);
        }
       return max;
    }

    public static void main(String[] args) {
        day300最长递增子序列 day300 = new day300最长递增子序列();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int i = day300.lengthOfLIS(nums);
        System.out.println(i);
    }
}
