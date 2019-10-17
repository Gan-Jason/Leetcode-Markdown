/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode pre=head;
        ListNode cur=head.next;
        recursiveReverse(head,pre,cur);
        pre.next=null;
        return tempHead;
    }
    private ListNode tempHead=null;
    private void recursiveReverse(ListNode head,ListNode pre,ListNode cur){
        if(cur==null){
            return;
        }
        recursiveReverse(head,pre.next,cur.next);
        if(cur.next==null)
            tempHead=cur;
        if(cur!=null)
            cur.next=pre;
    }
}
