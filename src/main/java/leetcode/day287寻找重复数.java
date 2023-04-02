package leetcode;

public class day287寻找重复数 {//要求不改变数组且只能用O(1)空间复杂度
//    方法一，最原始的遍历 两个值相等则为重复,但是时间复杂度为O(n^2)。超时
//    二分法 时间复杂度：O(nlogn)
    public int findDuplicate(int[] nums) {
        int min=1;
        int max=nums.length;
        while(max>min){
            int mid=(min+max)/2;
            int n=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]<=mid) n++;
            }
            if(n>mid)
                max=mid;
            else//n=mid
                min=mid+1;//别忘了加一
        }
        return min;
    }
    //    快慢指针
    public int findDuplicate2(int[] nums) {
        int slow=nums[0];
        int fast=nums[slow];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        slow=0;
        while (slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        day287寻找重复数 day287 = new day287寻找重复数();
        int[] nums = {1, 3, 4, 2, 2};
        int duplicate2 = day287.findDuplicate2(nums);
        System.out.println(duplicate2);

    }
}
