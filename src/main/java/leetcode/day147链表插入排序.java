package leetcode;

public class day147链表插入排序 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode lastSort=dummy;
        ListNode curr=lastSort.next;//lastSort.next;
        ListNode next=curr;
        while(next!=null){
            curr=next;
            next=next.next;

            ListNode curr2=dummy;
            while(curr2.next!=lastSort.next){
                if(curr2.next.val<curr.val){//curr2没有走到lastSort，lastsort不变
                    curr2=curr2.next;
                }else{
                    lastSort.next=next;
                    curr.next=curr2.next;
                    curr2.next=curr;
                    break;
                }
            }
           if(curr2.next==lastSort.next)
               lastSort=lastSort.next;//走到最后一个数了
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        day147链表插入排序 day147 = new day147链表插入排序();
        ListNode a= new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(5,new ListNode(4)))));
        ListNode listNode = day147.insertionSortList(a);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
