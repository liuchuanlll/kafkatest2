package leetcode;

public class day35二分_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        int right = nums.length-1;
        int left = 0;
        while(left<=right){
            int middle = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
            if (nums[middle] > target) {
                right = middle - 1; // target 在左区间，所以[left, middle - 1]
            } else if (nums[middle] < target) {
                left = middle + 1; // target 在右区间，所以[middle + 1, right]
            } else { // nums[middle] == target
                return middle;
            }
        }
        return right + 1;
    }
}
