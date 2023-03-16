package mytest;

import java.util.Arrays;

public class 插入排序 {
    public void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
            int i1 = array[i];
            for(int j=i-1;j>=0;j--){
                if(i1 <array[j]) array[j+1]=array[j];
                else{
                    array[j+1]= i1;break;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 3, 5, 2, 3, 2, 5, 9, 2, 1};
        new 插入排序().insertSort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
