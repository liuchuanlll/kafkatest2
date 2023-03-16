package mytest;

public class 快速排序 {//分割交换原理
    public int[] quickSort(int[] array,int left,int right){

        int start=left+1;
        int end=right;
        while(start<=end){
            while(array[start]<=array[left]&&start<=end) start++;
            while(array[end]>=array[left]&&start<=end) end--;
            if(start<end){
                int temp=array[start];array[start]=array[end];array[end]=temp;
                start++;end--;
            }
           int temp=array[left];array[left]=array[end];array[end]=temp;
        }
        if(left<end-1)//左边超过一个元素
            quickSort(array,left,end-1);
        if(start+1<end)
            quickSort(array,start,right);

        return array;
    }
}
