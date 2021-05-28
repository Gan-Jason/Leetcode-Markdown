//这题是删除链表一个节点，但是只给你这个要删除的节点
//看了半天题目，觉得是题目出错了。但其实是有一点开放性了，可以用下一个节点的值覆盖node，node.next删掉
//有点机灵

class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
