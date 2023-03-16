package leetcode;

import java.util.Arrays;

public class day16最接近的三数之和 {
    public int threeSumClosest(int[] nums, int target) {
        int ans=nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(Math.abs(target - ans) >= Math.abs(target - sum)){
                        ans = sum;
                    }
                }
            }
        }
        return ans;
    }
//    给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//
//    返回这三个数的和。
//
//    假定每组输入只存在恰好一个解。
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=nums[0] + nums[1] + nums[2];
        int minSub=Math.abs(target-ans);
        for(int i=0;i<nums.length-2;i++){
//            // 保证和上一次枚举的元素不相等.剪枝操作，此处只求sum值，不求具体三个数，可以不写
//            if (i > 0 && nums[i] == nums[i - 1]) {
//                continue;
//            }
           int leftFoot=i+1;
           int rightFoot=nums.length-1;
            while(leftFoot<rightFoot){
                int tempAns=nums[i]+nums[leftFoot]+nums[rightFoot];
                if(tempAns==target) return target;
                else {
                    int tempSub=Math.abs(target-tempAns);
                    if(tempSub<minSub) {ans=tempAns;minSub=tempSub;}
                    if(tempAns<target) leftFoot++;
                    if(tempAns>target) rightFoot--;
                }

            }

        }
        return ans;
    }
}
