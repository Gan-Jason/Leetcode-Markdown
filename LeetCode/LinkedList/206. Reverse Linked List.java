//链表的基本操作，有三个基本方法：
//1. 迭代法，一次遍历，用三个指针pre,cur,next pre为cur前一个指针，next指向cur的next，当next!=null为循环条件
//2. 递归，dfs，bottom up，利用子问题返回的答案构建当前的节点和子问题节点的反转，并返回head。
//3. 头插法，把每个节点插在链表头部。
//常识，一般地都会构造一个虚拟头节点指向链表头部，省去一些分类讨论
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode h;
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        //1. 一次遍历，递推
        // ListNode pre=head,p=head.next,q=p.next;
        // head.next=null;
        // while(q!=null){
        //     p.next=pre;
        //     pre=p;
        //     p=q;
        //     q=q.next;
        // }
        // p.next=pre;
        // return p;
        //2. dfs，bottom up
        // dfs(head);
        //3.头插法
        ListNode fake=new ListNode(-1);
        fake.next=head;
        ListNode cur=head,next;
        while(cur.next!=null){
            next=cur.next;
            cur.next=next.next;
            next.next=fake.next;
            fake.next=next;
        }
        head=fake.next;
        fake=null;
        return head;
    }

    private ListNode dfs(ListNode head){
        if(head.next==null){
            h=head;	//这里其实不用全局变量保存头节点，只要不移动指向原链表最后一个指针即可，返回的ans就是反转后的链表的头节点，而不是尾节点
            return head;
        }
        ListNode ans=dfs(head.next); //问子问题要答案
        ans.next=head;
        head.next=null;
        return head;
    }

}
