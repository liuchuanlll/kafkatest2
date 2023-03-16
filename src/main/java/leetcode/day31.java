package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class day31 {
    public void nextPermutation(int[] nums) {
        int length=nums.length;
        int i;
        for(i=length-2;i>=0;i--){//3 2 1
            if(nums[i]<nums[i+1])
                break;
        }
        if(i==-1){
            sort(nums,i+1,length-1);
        }else{// 4 2i 3 2 1 0
            for(int j=length-1;j>i;--j){
                if(nums[j]>nums[i]) {
                    change(nums,j,i);
                    break;
                }
            }
            sort(nums,i+1,length-1);
        }

    }
    public static void change(int[] nums,int j,int t){
        int x=nums[j];
        nums[j]=nums[t];
        nums[t]=x;
    }
    public static void sort(int[] nums,int left,int right){
        while (left < right) {
            change(nums, left, right);
            left++;
            right--;
        }

    }

    public static void main(String[] args) {
        int[] a=new int[]{1,3,2};
        new day31().nextPermutation(a);
        System.out.println(Arrays.toString(a));

    }
}
