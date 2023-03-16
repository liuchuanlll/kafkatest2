package leetcode;

import java.util.HashMap;
import java.util.Map;

public class day136只出现一次的数字 {


//    利用 Hash 表，Time: O(n) Space: O(n)O(n)O(n)
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }

//        根据异或性质:a^a=0，a^0=a，a^b=b^a ,异或是机器码运算，相同为0不同为1，不管数字先后，只要两个数字相同对应的二进制都会被异或为00000000，最后剩下的就是所要找的值
    public int singleNumber2(int[] nums) {
        int ans = nums[0];
        if(nums.length <= 1) return ans;
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(1^2);//会先转换成2进制
        System.out.println(2^3);

    }
}
