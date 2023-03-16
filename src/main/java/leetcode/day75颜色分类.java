package leetcode;


import java.util.Arrays;

import static leetcode.day48旋转图像.swap;

public class day75颜色分类 {
    //双指针两次遍历，模仿day283解法2 第一次遍历将0换到数组的头部。第二次遍历将1换到0后的头部
    public void sortColors(int[] nums) {
        int i=0,j=nums.length-1;
        while(i<j){//第一次遍历将0换到数组的头部。
            while(nums[i]==0&&i<j)
                i++;
            while(nums[j]!=0&&i<j)
                j--;
            if(i<j) swap(nums,i,j);
        }
        int k=nums.length-1;
        while(i<k){//第二次遍历将2换到数组的尾部。
            while(nums[i]==1&&i<k) i++;
            while(nums[k]!=1&&i<k) k--;
            if(i<k) swap(nums,i,k);
        }
    }

    //双指针一次遍历 类比day283解法一，i是循环变量默认不是指针
    public void sortColors2(int[] nums) {
        int p0=0,p1=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                swap(nums,i,p0);
                if(p0<p1) swap(nums,i,p1);
                p0++;
                p1++;
            }
            if(nums[i]==1){
                swap(nums,i,p1);
                p1++;
            }
        }

    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        day75颜色分类 day75= new day75颜色分类();
        int[] nums = {2, 0, 2, 1, 1, 0};
        day75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
