'''Given a linked list, determine if it has a cycle in it.To represent a cycle in the given linked list,
we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to.
If pos is -1, then there is no cycle in the linked list.'''


# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def hasCycle(self, head):                                             #判断一个链表是否为循环链表，用快慢指针法
        """
        :type head: ListNode
        :rtype: bool
        """
        if not head or not head.next:                                      #如果为空链表或者只有一个节点的链表 ，则返回False
            return False  
        p = head.next                                                      #p指针比q快两步，初始化为p在q的后一位
        q = head
        while p != q:                                                      #如果p能追上上q，则链表为循环链表，如果遍历一遍后，p还遇不到q，则不是循环链表
            if not p or not p.next:
                return False
            else:                                                          #其实这里也可以用抛异常的方法来捕获不符合循环链表的情况，即在遍历过程中出现错误的都不是循环链表，
                p = p.next.next                                            #用try...except...语句可以精简代码，但是可读性就降低一点
                q = q.next
        return True                                                         
        
