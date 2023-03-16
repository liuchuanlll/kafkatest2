package leetcode;


import java.util.Stack;

public class day206反转链表 {
    public static ListNode reverseList(ListNode head) {
//        ListNode reverseLode=head;
//        if(head.next!=null){head=head.next;reverseLode.next=null;}
//        while(head.next!=null){
//            ListNode temp=head;
//            head=head.next;
//            temp.next=reverseLode;
//            reverseLode=temp;
//        }
//        head.next=reverseLode;
//        return head;
//================头插法
//        ListNode dummy = new ListNode(0);
//        ListNode p = dummy, cur = head;
//        while(cur != null){
//            //从head摘下一个头
//            ListNode t = cur;
//            cur = cur.next;     //cur移到下一个
//            t.next = p.next;    //头插法插入
//            p.next = t;
//        }
//        return dummy.next;
//        ===================标准接法
        ListNode pre=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }
    public ListNode reverseList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        //把链表节点全部摘掉放到栈中
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty())
            return null;
        ListNode node = stack.pop();
        ListNode dummy = node;
        //栈中的结点全部出栈，然后重新连成一个新的链表
        while (!stack.isEmpty()) {
            ListNode tempNode = stack.pop();
            node.next = tempNode;
            node = node.next;
        }
        //最后一个结点就是反转前的头结点，一定要让他的next
        //等于空，否则会构成环
        node.next = null;
        return dummy;
    }
    public static ListNode reverseList(ListNode head,int k) {
        ListNode pre=null;
        ListNode curr=head;
        int i=0;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
            i++;
            if(i==k) break;
        }
        return pre;
    }
    public static void main(String[] args) {
        ListNode a= new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        ListNode listNode = reverseList(a);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}



