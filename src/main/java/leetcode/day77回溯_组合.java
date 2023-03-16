package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class day77回溯_组合 {
    List<ArrayList<Integer>> listList=new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> myList=new ArrayList<Integer>();

    public void combine(int n, int k,int index) {
        if(k==myList.size()){
            ArrayList<Integer> temp=new ArrayList<Integer>(myList);
            listList.add(temp);
            System.out.println(listList);
            return ;
        }
        for(int i=index;i<=n;i++){
            myList.add(i);
            combine(n,k,i+1);
            myList.remove(myList.size()-1);
        }

    }




    public static void main(String[] args) {
        day77回溯_组合 day77 = new day77回溯_组合();
        day77.combine(4,2,1);
        System.out.println(day77.listList);
    }
}
