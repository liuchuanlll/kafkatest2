package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/14 10:38
 * @Description
 */
public class day739每日温度 {
    public int[] dailyTemperature(int[] temperatures){
        int[] nextTemper = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();//存储数组下标
        for(int i=0;i<temperatures.length;i++){
            while(!stack.empty()&&temperatures[i]>temperatures[stack.peek()]){
                Integer pop = stack.pop();//出栈
                nextTemper[pop]=i-pop;
            }
            stack.push(i);
        }
        return nextTemper;
    }

    public static void main(String[] args) {
        day739每日温度 day739 = new day739每日温度();
        int[] temperature = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = day739.dailyTemperature(temperature);
        System.out.println(ints);

    }
}
