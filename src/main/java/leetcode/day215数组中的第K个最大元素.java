package leetcode;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/20 16:10
 * @Description
 */
public class day215数组中的第K个最大元素 {
    //参考快速排序，在一次递归后判断k在左边还是右边，进而只进行一边的递归
    public int findKthLargest(int[] nums,int k){
        int maxK = getMaxK(nums, 0, nums.length - 1, nums.length - k);
        return maxK;

    }

    public int getMaxK(int nums[],int left,int right,int k){
        int start=left+1;
        int end=right;
        while(start<=end){
            while(nums[start]<=nums[left]&&start<=end) start++;
            while(nums[end]>=nums[left]&&start<=end) end--;
            if(start<end){
                swap(nums, start, end);
                start++;end--;
            }
        }// 结束刚好end+1=start。数组为a[left],small[left+1,end],large[start,right]
        swap(nums, left, end);//不用整个数组交换,仅交换a和small[end],数组为small[left,end-1],a[end],large[start,right]
        if(k==end) {
            return nums[end];
        }else if(k>=left&&k<=end-1){
            if(end-1-left>1){//左边超过一个元素
                return getMaxK(nums,left,end-1,k);
            }else{
                return nums[left];
            }
        }else{
            if(right-start>1){//右边超过一个元素
                return getMaxK(nums,start,right,k);
            } else{
                return nums[right];
            }
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
