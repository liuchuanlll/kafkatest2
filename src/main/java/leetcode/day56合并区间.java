package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class day56合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        int[] maxMerge=intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>maxMerge[1]){
                merged.add(maxMerge);
                maxMerge=intervals[i];
            } else {
                maxMerge=new int[]{maxMerge[0],Math.max(maxMerge[1],intervals[i][1])};
            }
        }
        merged.add(maxMerge);
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        day56合并区间 day56 = new day56合并区间();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = day56.merge(intervals);
        for(int[] ints:merge){
            System.out.print(Arrays.toString(ints));
        }
    }
}
