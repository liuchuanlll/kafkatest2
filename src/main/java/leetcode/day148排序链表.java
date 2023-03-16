package leetcode;

public class day148排序链表 {
//    方法一：自顶向下归并排序，使用到递归，但是只要不是尾递归就需要消耗logn的空间复杂度   时间复杂度：O(nlogn)  空间复杂度：O(logn)
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode preMidNode = new day876链表的中间结点().middleNode2(head);//注意链表长度为偶数时，返回第 1个结点的细节
        ListNode afterMidNode = preMidNode.next;
        preMidNode.next = null;
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(afterMidNode);
        ListNode paixulianbiao = new day21合并两个有序链表().paixulianbiao(list1, list2);
        return paixulianbiao;
    }

//        方法二：自底向上迭代
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int length = 1;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        for(int i=1;i<length;i*=2){
            for(int j=0;j<i;j++){

            }
        }
        return node;
    }
}
