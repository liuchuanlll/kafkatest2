package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/4/3 10:31
 * @Description
 */
public class day283除自身以外数组的乘积 {
//    一  n[i]=memo[0,i-1]*memo[i+1,nums.length] 时间复杂度O(n),空间复杂度O(n)
    public int[] productExceptSelf(int[] nums){
        int length = nums.length;
        int[] l=new int[length];
        int[] r=new int[length];
        int[] ans=new int[length];
        l[0]=nums[0];
        r[length-1]=nums[length-1];
        for(int i = 1; i< length-1; i++){
            l[i]=l[i-1]*nums[i];
            r[length-1-i]=r[length-i]*nums[length-1-i];
        }
        ans[0]=r[1];
        ans[length-1]=l[length-2];
        for(int i = 1; i< length-1; i++){
           ans[i]=l[i-1]*r[i+1];
        }
        return ans;
    }
    //    二  不引入O(n)的额外空间复杂度
    public int[] productExceptSelf2(int[] nums){
        int length = nums.length;
        int[] ans=new int[length];
        ans[0]=1;
        for(int i = 1; i< length; i++){
            ans[i]=ans[i-1]*nums[i-1];
        }
        int t=1;
        for(int i = length-2; i>=0; i--){
            t=t*nums[i+1];
            ans[i]=ans[i]*t;
        }
        return ans;
    }

    public static void main(String[] args) {
        day283除自身以外数组的乘积 day283 = new day283除自身以外数组的乘积();
        int[] nums = {1, 2, 3, 4};
        int[] ints = day283.productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }
}
