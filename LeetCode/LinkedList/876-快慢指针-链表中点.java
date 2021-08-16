//快慢指针，如果是fast走的速度是slow的两倍，则fast的路程也是slow的两倍。当fast走完length时，slow走的就是length/2
//注意：两个指针可以同时从起点出发
//如果是需要其他的速度，也同理，根据题目不同情况选择

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){   //注意判断是否走到终点了
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
