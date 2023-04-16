package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class day2251花期内花的数目 {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Arrays.sort(flowers, new Comparator<int[]>() {//flowers[0] flowers[1]均为升序
            @Override
            public int compare(int[] o1, int[] o2) {
               if(o1[0]==o2[0])
                   return o1[1]-o2[1];
               return o1[0]-o2[0];
            }
        });
        for()
        return null;
    }
}
