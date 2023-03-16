package leetcode;

import java.util.Arrays;

public class day283移动零 {
//    方法一：单指针j,i此处可不看做指针
    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                swap(nums,i,j);
                j++;
            }
        }
    }
//    解法二：使用双指针，左指针指向当前已经处理好的序列的尾部，右指针指向待处理序列的头部。

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new day283移动零().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
