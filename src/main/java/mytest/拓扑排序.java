package mytest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2023/3/20 13:55
 * @Description
 */
public class 拓扑排序 {

    public static void main(String[] args) {
//        String[] courses = {"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9"};
//        String[][] relations=new String[][]{{"C1","C3"},{"C1","C8"},{"C2","C3"},{"C3","C4"},{"C5","C4"},{"C2","C5"},{"C4","C5"},{"C4","C7"},{"C9","C7"},{"C8","C9"}};
        int courses = 6;
        int count=0;//输出的顶点数
        int[][] relations=new int[][]{{0,2},{1,4},{1,3},{1,2},{2,5},{2,3},{3,5},{4,5}};
        ArrayList<Integer>[] arrayLists = new ArrayList[courses];
        int[] ints = new int[courses];
        for(int i=0;i<arrayLists.length;i++){
            arrayLists[i]=new ArrayList<>();
        }
        for(int[] relation:relations){
            ints[relation[1]]++;
            arrayLists[relation[0]].add(relation[1]);
        }
        System.out.println(arrayLists[5]);
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
        System.out.println(Arrays.toString(ints));//ints数组所有值均为0则说明无环
        System.out.println(count==courses);//true说明输出的顶点数==课程数，无环。
    }
}
