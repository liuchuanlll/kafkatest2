package leetcode;

import java.util.Arrays;

public class day11最多容器的水 {
    public static int maxArea(int[] height) {
        int maxSize=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int size=(right-left)*(Math.min(height[left],height[right]));
            maxSize=Math.max(maxSize,size);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxSize;
    }
    public static int maxArea2(int[] height) {
        int right=height.length-1;
        if(right==1){return Math.min(height[0],height[1]); }
//        while(left<right){
            int size=right*(Math.min(height[0],height[right]));
//            maxSize=Math.max(maxSize,size);
            if(height[0]<height[right]){
                height= Arrays.copyOfRange(height,1,++right);
            }else{
                height= Arrays.copyOfRange(height,0,right);
            }
//        }
        return Math.max(size,maxArea2(height));
    }
    public static void main(String[] args) {
        int i = maxArea2(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }
}

