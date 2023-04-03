package leetcode;

import java.util.Arrays;

public class day621任务调度器 {//只求最值，不输出过程
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length <= 1 || n < 1) return tasks.length;
        int[] cnt=new int[26];
        for(char task:tasks){
            cnt[task-'A']++;
        }
        Arrays.sort(cnt);
//        int[] interval=new int[26];
//cnt[0]*n-
        return 0;
    }
}
