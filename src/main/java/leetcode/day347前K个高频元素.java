package leetcode;

import java.util.*;

public class day347前K个高频元素 {
    //先统计出每个数字的次数 O(n)，获取频率后，进行快排，然后二分选一半继续快排O(n)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occurs = new LinkedHashMap<>();
        for(int n:nums){
            occurs.put(n,occurs.getOrDefault(n,0)+1);
        }
        int[][] ints = new int[occurs.size()][2];
        int i=0;
        for(Map.Entry<Integer,Integer> occur:occurs.entrySet()){
            ints[i][0]=occur.getKey();
            ints[i++][1]=occur.getValue();
        }
        quickSort(ints,0,ints.length-1,ints.length-k);
        int[] ints1 = new int[k];
        for(i=0;i<k;i++)
            ints1[i]=ints[ints.length-i][1];
        return ints1;
    }

    private void quickSort(int[][] array, int l, int r,int k) {
        int start=l+1;
        int end=r;
        while(start<=end){
            while(array[l][1]<=array[start][1]) start++;
            while(array[l][1]>array[end][1]) end--;
            if(start<end){
                swap(array,start,end);
                start++;end--;
            }
            swap(array, l, end);

            if(k>end)  quickSort(array,end+1, r, k);
            if(k<end)  quickSort(array,l, end-1, k);
        }

    }
    public static void swap(int[][] array, int start, int end) {
        int[] temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
    //方法二：先统计出每个数字的次数 O(n)   然后堆排序O(nlogk)
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> occurs = new LinkedHashMap<>();
        for(int n:nums){
            occurs.put(n,occurs.getOrDefault(n,0)+1);
        }
        //建立一个maxK-max的小跟堆,进出都从根节点
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1]-o2[1];
            }
        });
        for(Map.Entry<Integer,Integer> occur:occurs.entrySet()){
            int num=occur.getKey();
            int count=occur.getValue();
            if(queue.size()<k) {
                queue.offer(new Integer[]{num,count});
            } else if(queue.size()==k&&queue.peek()[1]<count){
                Integer[] poll = queue.poll();
                queue.offer(new Integer[]{num,count});
            }
        }
        int[] ints1 = new int[k];
        for(int i=0;i<k;i++)
            ints1[i]=queue.poll()[1];
        return ints1;

    }
}
