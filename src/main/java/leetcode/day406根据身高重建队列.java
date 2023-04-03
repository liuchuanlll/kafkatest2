package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class day406根据身高重建队列 {
//    先对输入数组排序，h升序，k降序 从头循环遍历 当前这个人就是剩下未安排的人中最矮的人，他的k值就代表他在剩余空位的索引值 如果有多个人高度相同，要按照k值从大到小领取索引值
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) return 1;
                if (a[0] == b[0] && a[1] > b[1]) return 1;
                return -1;
            }
        });//people[0]从大到小，people[1]从小到大
//        Arrays.sort(people, (a, b) -> {
//            if (a[0] == b[0]) return a[1] - b[1];
//            return b[0] - a[0];
//        });
        ArrayList<int[]> integersList = new ArrayList<>();
        for(int[] p:people){
            integersList.add(p[1],p);
        }
        return integersList.toArray(new int[integersList.size()][]);
    }

    public static void main(String[] args) {
        day406根据身高重建队列 day406 = new day406根据身高重建队列();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = day406.reconstructQueue(people);
        for(int[] ints1:ints){
            System.out.println(Arrays.toString(ints1));
        }
    }
}
