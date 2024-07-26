
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
 
    //直接插入法对链表进行排序
    public ListNode insertionSortList(ListNode head) {
        if(head==null)
            return head;
        ListNode work_p=head.next;
        ListNode work_slow=head;
        if(work_p==null)
            return head;
        //把work_p指针前的链表都认为是有序的链表
        while(work_p!=null){
            //p是从链表头部开始往后面遍历
            ListNode p=head;
            ListNode p_slow=null;
            //找到一个比work_p大的结点，把work_p结点插在该结点的前面
            while(p!=work_p&&p.val<=work_p.val){
                p_slow=p;
                p=p.next;
                
            }
            if(p.val>work_p.val){
                if(p_slow==null){
                    work_slow.next=work_p.next;
                    work_p.next=p;
                    head=work_p;
                    work_p=work_slow.next;
                }else{
                    work_slow.next=work_p.next;
                    work_p.next=p;
                    p_slow.next=work_p;
                    work_p=work_slow.next; 
                }

            }
            //如果work_p的位置是准确的，则往后遍历
            else{
                work_slow=work_p;
                work_p=work_p.next;
            }
            
        }
        return head;
    }
