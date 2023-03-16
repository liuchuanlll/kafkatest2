package leetcode;

import java.util.HashSet;

public class day128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for(int n:nums){
            integers.add(n);
        }
        int max=0;
        for(int n:integers){
            if(integers.contains(n-1)) continue;
            int currLong=1;
            while(integers.contains(++n)){
                currLong++;
            }
            max=Math.max(currLong,max);
        }
        return max;
    }
}

