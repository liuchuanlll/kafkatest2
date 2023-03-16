package leetcode;


public class day33二分_搜索旋转排序数组 {
    public int search(int[] nums, int target) {
        int length=nums.length;
        int left=0;
        int right=length-1;
        if(left==right) return target==nums[0]?0:-1;
        while(left<=right){
            if(target>right&&target<left) return -1;
            int mid=(left+right)/2;
            if(nums[mid]==target) return mid;
            //前半部分有序,注意此处用小于等于
            if(nums[mid]>nums[left]){
                if(target<nums[mid]&&target>=nums[left]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            } else {
                if(target>nums[mid]&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] a=new int[]{1,3};
        int search = new day33二分_搜索旋转排序数组().search(a, 0);
        System.out.println(search);
    }
}
