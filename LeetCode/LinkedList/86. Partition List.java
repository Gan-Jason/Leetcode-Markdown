  /**
  * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
  *
  * You should preserve the original relative order of the nodes in each of the two partitions.
  */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //把链表的小于x节点(下简称小节点)全部排到大于等于x节点（下简称大节点）前面去，大于等于x节点的相对顺序不变
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return head;
        //head1是小节点的链表头节点,head_temoListNode是小节点链表的工作指针
        ListNode head_tempListNode=new ListNode(0),head1=head_tempListNode,
        //原链表的工作指针
        curListNode=head,
        //pre指针
        preListNode=new ListNode(-1);
        preListNode.next=head;
        while(curListNode!=null){
            //如果当前节点是小节点则，原链表跳过这个节点，小节点链表加入这个节点
            if(curListNode.val<x){
                head_tempListNode.next=curListNode;
                head_tempListNode=head_tempListNode.next;

                preListNode.next=curListNode.next;
                //若当前节点为头节点，则需要移动头节点到下一节点
                if(curListNode==head)
                    head=curListNode.next;
            //此时，只需要移动当前节点指针
            curListNode=curListNode.next;
            }
            //若不是小节点，则pre指针和当前指针都往后移动
            else{
                curListNode=curListNode.next;

                preListNode=preListNode.next;
            }
        }
        head_tempListNode.next=head;
        return head1.next;
    }
}
