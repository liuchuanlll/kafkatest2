package leetcode;

public class day55跳跃游戏 {
    public boolean canJump(int[] nums) {
        int maxFoot=0;
        for(int i=0;i<nums.length;i++){
            maxFoot=Math.max(maxFoot,i+nums[i]);
            if(maxFoot<=i&&i!=nums.length-1)//
                return false;
        }
        return true;
    }
}
