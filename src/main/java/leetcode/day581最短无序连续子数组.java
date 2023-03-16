package leetcode;

public class day581最短无序连续子数组 {
    //题解一 先排序然后和原数组比对，时间复杂度o（nlogn）,略
    //题解二
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length<2||isSorted(nums))
            return 0;
        int leftFoot=0,rightFoot=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]) {
                leftFoot=i;
                break;
            }
        }
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]<nums[i-1]){
                rightFoot=i;
                break;
            }
        }
        int subMax=nums[leftFoot],subMin=nums[rightFoot];
        for(int i=leftFoot;i<=rightFoot;i++){
            subMax=Math.max(subMax,nums[i]);
            subMin=Math.min(subMin,nums[i]);
        }
        int a=0,b=0;
        for(int i=0;i<=leftFoot;i++){
            if(nums[i]>subMin) {
                a=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=rightFoot;i--){
            if(nums[i]<subMax){
                b=i;
                break;
            }
        }
        return b-a+1;
    }
    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

}
