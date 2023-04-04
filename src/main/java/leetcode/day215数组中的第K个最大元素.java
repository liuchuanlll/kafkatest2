package leetcode;

import java.util.PriorityQueue;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/20 16:10
 * @Description
 */
//    全局排序，O(n*lg(n))
//    局部排序，只排序TopK个数，O(n*k)
//    堆排序TopK个数也不排序了，O(n*lg(k))
//    分治法，每个分支“都要”递归，例如：快速排序，O(n*lg(n))
//    减治法，“只要”递归一个分支，例如：二分查找O(lg(n))，随机选择=n+n/2+n/4+n/2^k+...1=n+1=O(n)
//    TopK的另一个解法：随机选择+partition
//    原文链接：https://blog.csdn.net/z50L2O08e2u4afToR9A/article/details/82837278
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
            while(start<nums.length&&nums[start]<=nums[left]&&start<=end) start++;
            while(nums[end]>=nums[left]&&start<=end) end--;
            if(start<end){
                swap(nums, start, end);
                start++;end--;
            }
        }// 结束刚好end+1=start。数组为a[left],small[left+1,end],large[start,right]
        swap(nums, left, end);//交换a和end,数组为small[left,end-1],a[end],large[start,right]
        if(k==end) {
            return nums[end];
        }else if(k<end){
            return getMaxK(nums,left,end-1,k);
        }else{
            return getMaxK(nums,start,right,k);
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        int maxK = new day215数组中的第K个最大元素().findKthLargest(new int[]{3,2,1,5,6,4}, 2);
        System.out.println(maxK);

    }
//    PriorityQueue（优先队列） 采用的是堆排序，实际上是一个堆（不指定Comparator时默认为最小堆）,队列的头是按指定排序方式的最小元素。如果多个元素都是最小值，则头是其中一个元素。
//    该队列是用数组实现，但是数组大小可以动态增加，容量无限。 插入方法（offer()、poll()、remove() 、add() 方法）时间复杂度为O(log(n)) ；
//    remove(Object) 和 contains(Object) 时间复杂度为O(n)；检索方法（peek、element 和 size）时间复杂度为常量。
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        for (int val : nums) {
            // 初始化堆
            if (pq.size() < k) {
                pq.add(val);
            } else {
                Integer peek = pq.peek();
                if (val > peek) {
                    pq.add(val);
                    pq.poll();
                }
            }
        }
        return pq.peek(); // 取出堆顶node不删除

    }
}
