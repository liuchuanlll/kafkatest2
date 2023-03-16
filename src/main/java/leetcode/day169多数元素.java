package leetcode;

import java.util.*;

public class day169多数元素 {
    //哈希表
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int x=counts.containsKey(num)?counts.get(num) + 1:1;
            counts.put(num,x);
        }
        int max=0;//最多出现次数
        int num=0;//出现最多次数的值
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
                num=entry.getKey();
            }
        }
        return num;
    }
    //方法二排序 取中法
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
//    方法四：分治


    //方法五  ① 当数组元素等于栈顶元素或栈为空时入栈；
    //② 当元素不等于栈顶元素时则出栈。
    //最后的栈顶元素即为众数。
    public int majorityElement5(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for(int i:nums){
            if(stack. empty()||i==stack.peek()){
                stack.push(i);
            }else{
                stack.pop();
            }
        }
        return stack.peek();
    }
//    方法六: 摩尔投票法，思想是抵消，是栈方法的降维。摩尔投票法为啥成立？因为这里的众数是指大于总数数目的二分之一，举两个个极端例子
    public int majorityElement6(int[] nums) {
        //几个军队抢山头
        int num = nums[0];//山头没人，我先来做霸王
        int cnt = 1;//记录山头的人数，目前就我一个
        for(int i = 1; i < nums.length; ++i){
            if(cnt == 0){//山头没人
                num = nums[i];//我来当霸王
            }
            if(nums[i] == num){
                cnt++;//帮派的人来撑腰了，票数++
            }
            else{
                cnt--;//敌方过来一人，出门应敌并同归于尽
            }

        }
        //选出来笑到最后的霸王
        return num;
    }
}
