package leetcode;


/**
 * @author kfzx-liuc02
 * @version 1.0
 * @date 2022/5/5 17:41
 * @Description
 */
public class day21合并两个有序链表 {


    public ListNode paixulianbiao(ListNode listNode1,ListNode listNode2){
        ListNode res=new ListNode(-1);
        ListNode temp=res;
        if(listNode1==null) return listNode2;
        if(listNode2==null) return listNode1;
        while(listNode1!=null&&listNode2!=null){
            if(listNode1.val<listNode2.val){
                ListNode node=new ListNode(listNode1.val);
                temp.next=node;
                temp=temp.next;
                listNode1=listNode1.next;
            } else {
                ListNode node=new ListNode(listNode2.val);
                temp.next=node;
                temp=temp.next;
                listNode2=listNode2.next;
            }
        }
        if(listNode1!=null) temp.next=listNode1;
        if(listNode2!=null) temp.next=listNode2;
        return  res.next;
    }
    public static void main(String[] args) {
        ListNode node1=new ListNode(1,new ListNode(3,new ListNode(5)));
        ListNode node4=new ListNode(2,new ListNode(4,new ListNode(6)));
        ListNode paixulianbiao =new day21合并两个有序链表().paixulianbiao(node1, node4);
        Print(paixulianbiao);
    }
    public static void Print(ListNode node){
        if(node !=null){
            System.out.println(node.val);
            Print(node.next);
        }
    }
}
