package leetcode;

import java.util.*;
import java.util.stream.IntStream;

//动态开点线段树/树状数组
//        离线查询+小根堆
public class day2251花期内花的数目 {//第 i 个人能看到的花的数目，等价于 start不晚于 personsi的花的数目，减去end早于personsi的花的数目，即开花数减去凋落数。所以单独统计开花时间和凋落时间，排序后二分就得到了答案。
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        Arrays.sort(flowers, new Comparator<int[]>() {//flowers[0] flowers[1]均为升序
            @Override
            public int compare(int[] o1, int[] o2) {
               if(o1[0]==o2[0])
                   return o1[1]-o2[1];
               return o1[0]-o2[0];
            }
        });
//        for()
        return null;
    }

//        离散化+差分  dp[i]=dp[i-1]+flowers[i][0]-flowers[i-1][1]
    public int[] fullBloomFlowers2(int[][] flowers, int[] persons) {
        Map<Integer, Integer> diff = new HashMap<>();
        for (int[] f : flowers) {
            diff.put(f[0], diff.getOrDefault(f[0], 0)+1);
            diff.put(f[1] + 1, diff.getOrDefault(f[1] + 1, 0) - 1);
        }
        // 提取有变化的时刻并排序
        Object[] times = diff.keySet().toArray();
        Arrays.sort(times);
        int[] numbers = new int[times.length];
        numbers[0]= (int) times[0];
        Arrays.sort(persons);
        int ans[] = new int[persons.length];
        int j=0;
        for(int i=1;i<times.length;i++){
            numbers[i]=numbers[i-1]+diff.get(times[i]);

        }

        return ans;
    }
    public int[] fullBloomFlowers3(int[][] flowers, int[] persons) {
        TreeSet<Integer> set=new TreeSet<>();
        set.add(0);
        for(int i=0;i<flowers.length;i++){
            set.add(flowers[i][0]);
            set.add(flowers[i][1]+1);
        }
        Map<Integer,Integer> map=new HashMap<>();
        int p=0;
        for(int a:set){
            map.put(a,p);
            p++;
        }
        int count[]=new int[p+5];
        for(int i=0;i<flowers.length;i++){
            count[map.get(flowers[i][0])]++;
            count[map.get(flowers[i][1]+1)]--;
        }
        for(int i=1;i<=p;i++){count[i]+=count[i-1];}
        for(int i=0;i<persons.length;i++){persons[i]=count[map.get(set.floor(persons[i]))];}
        return persons;
    }
    public static void main(String[] args) {
        day2251花期内花的数目 day2251 = new day2251花期内花的数目();
        int[][] flowers = {{1, 10}, {3, 3}};
        int[] persons = {3, 3, 2};
        int[] ints = day2251.fullBloomFlowers2(flowers, persons);
        System.out.println(Arrays.toString(ints));
    }
}
