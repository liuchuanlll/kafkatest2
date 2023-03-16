package leetcode;

import javax.lang.model.element.VariableElement;

public class day23合并K个升序链表 {
    day21合并两个有序链表 day21=new day21合并两个有序链表();
    public ListNode listNode(ListNode[] lists){
        int length=lists.length;
        if(lists==null||lists.length==0) return null;
        while (length>1){
            for(int i=0;i<length/2;i++){
                lists[i]=day21.paixulianbiao(lists[i],lists[length-i-1]);
            }
            length=length/2+length%2;
        }
        return lists[0];
    }


    public static void main(String[] args) {
//        [[1,4,5],[1,3,4],[2,6]]
        ListNode listNode1=new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode listNode2=new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode listNode3=new ListNode(2,new ListNode(6));
        ListNode[] a=new ListNode[]{listNode1,listNode2,listNode3};
        ListNode listNode = new day23合并K个升序链表().listNode(a);
        System.out.println(listNode);
    }
}
