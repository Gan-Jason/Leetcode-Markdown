'''Write a program to find the node at which the intersection of two singly linked lists begins.'''

class Solution(object):
    def getIntersectionNode(self, headA, headB):                                #找到两个链表的公共部分的首节点，即节点的值相等，next指针相等
        """                                                                     #这个问题有两个办法，一个是利用哈希表存储A链表的结点引用或者地址
        :type head1, head1: ListNode                                            #第二方法是，双指针法，P指针指向A表头，q指向B表头，分别遍历，当
        :rtype: ListNode                                                        #其中一个工作指针为空时，则该指针重新指向另一个表的表头重新遍历
        """                                                                     #当两者指向相同的节点时完成遍历，若两者皆为空时结束遍历并返回空
        if not headA or not headB:
            return None
        p = headA
        q = headB
        while p and q and q!=p:   
            p = p.next
            q = q.next
            if q == p:
                return p

            if p is None:
                p = headB
            if q is None:
                q = headA
        return q
        
