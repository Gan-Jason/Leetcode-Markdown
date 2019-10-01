/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 */
 
 
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //归并法链表排序
    public ListNode sortList(ListNode head){
        if(head==null||head.next==null)
            return head;
        //把链表切为两半，用快慢指针法，
        ListNode pre=null,slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        pre.next=null;
        //递归归并左右子链表，最后也就是两两排序
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        //再合并排好序的链表
        return merge(l1,l2);
    }
    //使用头插法对两个链表合并
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode head;
        if(l1.val<=l2.val){
            head=l1;
            l1=l1.next;
        }else {
            head=l2; 
            l2=l2.next;
        }   
        ListNode p=head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next=l1;
                l1=l1.next;
            }else{
                p.next=l2;
                l2=l2.next;

            }
            p=p.next;
        }
        if(l1!=null)
            p.next=l1;
        else
            p.next=l2;
        return head;
    }
}
