package leetcode;

import java.util.HashMap;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/14 12:17
 * @Description
 */
public class day560和为K的子数组 {
    //思路一、暴力for循环或者回溯：超时
    //思路二、滑动窗口：有负数，不适用
//    思路三：前缀和，pre[j-1]==pre[i]-k,构建前缀和数组，以快速计算。时间复杂度【On^2】
//    思路四:前缀和+哈希表优化：由于只关心次数，不关心具体的解，可以使用hash表加速，类似leetcode1,，每次循环将Map(pre[i],count++)添加进map里表示pre[i]之前出现过的次数
    public int subarraySum(int[] nums,int k){
//        计算前缀和
        int[] preSum=new int[nums.length];
        preSum[0]=nums[0];
        for(int i=1;i< nums.length;i++){
            preSum[i]=preSum[i-1]+nums[i];
        }
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        int count=0;
        integerHashMap.put(0,1);//刚开始初始化出现默认和为0,出现了1次。初始化{0，1}可以看作是在前缀和前多加了一个和，是为了防止从序号0开始加到i时刚好为k的情况出现时，没法找到对应数值计数
        for(int i=0;i< preSum.length;i++){
            if(integerHashMap.containsKey(preSum[i]-k)){
                count+=integerHashMap.get(preSum[i]-k);
            }
            integerHashMap.put(preSum[i],integerHashMap.getOrDefault(preSum[i],0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        day560和为K的子数组 day560 = new day560和为K的子数组();
//        int[] nums = {1, 1, 1};
//        int k=2;
        int[] nums = {1};
        int k=0;
        int i = day560.subarraySum(nums, k);
        System.out.println(i);
    }
}
