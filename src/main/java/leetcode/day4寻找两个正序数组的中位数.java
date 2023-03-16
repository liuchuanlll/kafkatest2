package leetcode;

import java.util.Arrays;

public class day4寻找两个正序数组的中位数 {
    //简单粗暴，先将两个数组合并，两个有序数组的合并也是归并排序中的一部分。然后根据奇数，还是偶数，返回中位数。
    //时间复杂度：遍历全部数组 (m+n),空间复杂度：开辟了一个数组，保存合并后的两个数组 O(m+n)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length= m + n;
        int[] nums3=new int[length];
        int i=0,j=0;
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }
        while(i<m&&j<n){
            if(nums1[i]<=nums2[j]) {nums3[i+j]=nums1[i];i++;}
            else  {nums3[i+j]=nums2[j];j++;}
        }
        while(i==m&&j<n){nums3[i+j]=nums2[j];j++;}
        while(j==n&&i<m){nums3[i+j]=nums1[i];i++;}
        System.out.println(Arrays.toString(nums3));
        int leftLength=length%2==0?length/2:(length+1)/2;//长度
        int rightLength=length%2==0?leftLength+1:leftLength;
        //int rightLength=length%2==0?length/2+1:(length+1)/2;
        double i1 = nums3[leftLength - 1] + nums3[rightLength - 1];
        return i1/2;

    }

    //直接找中间值，时间复杂度：遍历 len/2+1 次，len=m+n，所以时间复杂度依旧是 O(m+n),空间复杂度O(1)
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length= m + n;
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
            } else {
                return nums2[n / 2];
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
            } else {
                return nums1[m / 2];
            }
        }
        int right=0,left=0;
        int i=0,j=0;
        for(int k=0;k<= length / 2;k++){
            left=right;
            if(j==nums2.length||(i<nums1.length&&nums1[i]<=nums2[j])) {//条件判断是关键
                right=nums1[i];
                i++ ;
            } else {
                right=nums2[j];
                j++;
            }
        }
        if ((length & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }
    //方法三 二分法
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length= m + n;
        int leftLength=length%2==0?length/2:(length+1)/2;//长度
        int rightLength=length%2==0?leftLength+1:leftLength;

            return 0;
    }

    public static void main(String[] args) {
        double Sorted = findMedianSortedArrays2(new int[]{3,4,5,6},new int[]{1,2});
        System.out.println(Sorted);
    }
}
