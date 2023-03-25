package mytest;

import java.util.Arrays;

public class 快速排序 {//分割交换原理
    public int[] quickSort(int[] array,int left,int right){

        int start=left+1;
        int end=right;
        while(start<=end){
            while(array[start]<=array[left]&&start<=end) start++;
            while(array[end]>=array[left]&&start<=end) end--;
            if(start<end){
                swap(array, start, end);
                start++;end--;
            }
        }// 结束刚好end+1=start。数组为a[left],small[left+1,end],large[start,right]

        swap(array, left, end);
        if(end-1-left>1)//左边超过一个元素
            quickSort(array,left,end-1);
        if(right-start>1)//右边超过一个元素
            quickSort(array,start,right);

        return array;
    }

    public static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public static void main(String[] args) {
        快速排序 quickSort = new 快速排序();
        int[] array = {4, 7, 5, 6, 71, 12, 2, 1, 536, 1};
        quickSort.quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }
}
