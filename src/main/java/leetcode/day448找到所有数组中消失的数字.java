package leetcode;

import java.util.ArrayList;
import java.util.List;

public class day448找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] ints = new int[nums.length];
        for(int n:nums){
            ints[n-1]=n;
        }
        ArrayList<Integer> integerList = new ArrayList<>();
        for(int i=0;i<ints.length;i++){
            if(ints[i]==0) integerList.add(ints[i]);
        }
        return integerList;
    }
}
