package leetcode;

public class day152乘积最大子序列 {
//    动态规划+状态转移：令imax为当前最大值，则当前最大值为 imax = max(max[i-1] * nums[i], nums[i])
//    由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])

    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] max = new int[length];
        int[] min = new int[length];
        max[0]=min[0]=nums[0];
        for(int i=1;i<length;i++){
            max[i]=Math.max(max[i-1] * nums[i],Math.max(min[i-1] * nums[i], nums[i]));
            min[i]=Math.min(min[i-1] * nums[i], Math.min(max[i-1] * nums[i], nums[i]));
        }
        int ans = max[0];
        for (int i = 0; i < length; ++i) {
            ans = Math.max(ans, max[i]);
            ans = Math.max(ans, min[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        day152乘积最大子序列 day152 = new day152乘积最大子序列();
        int[] nums = {-2, 3, -4};
        int i = day152.maxProduct(nums);
        System.out.println(i);
    }
}
