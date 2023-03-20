package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/20 15:39
 * @Description
 */
public class day207课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count=0;//输出的顶点数
        ArrayList<Integer>[] arrayLists = new ArrayList[numCourses];
        int[] ints = new int[numCourses];
        for(int i=0;i<arrayLists.length;i++){
            arrayLists[i]=new ArrayList<>();
        }
        for(int[] relation:prerequisites){
            ints[relation[1]]++;
            arrayLists[relation[0]].add(relation[1]);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<ints.length;i++){
            if(ints[i]==0) stack.push(i);
        }
        while(!stack.empty()){
            Integer pop = stack.pop();
            count++;//输出的定点数
            ArrayList<Integer> arrayList = arrayLists[pop];
            for(int i=0;i<arrayList.size();i++){
                if(--ints[arrayList.get(i)]==0) stack.push(arrayList.get(i));
            }
        }
       return count==numCourses;//true说明输出的顶点数==课程数，无环。
    }
}
