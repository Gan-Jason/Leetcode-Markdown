/**
* You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
* The binary tree has the following definition:
*
* struct Node {
*  int val;
*  Node *left;
*  Node *right;
*  Node *next;
* }
*
* Populate each next pointer to point to its next right node. 
* If there is no next right node, the next pointer should be set to NULL.
* Initially, all next pointers are set to NULL.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    //二叉树结点中新增一个next指针，指向该节点同一层的右邻结点，如果没有右邻结点则该next指针为空
    //遍历一棵二叉树，把该树的所有节点的next指针指向正确的位置
    //我的思路是，既然该指针是指向同一层次的相邻节点，则可以考虑层次遍历，但我不明白的是，我的层次遍历只遍历了一遍所有的树节点，理论上的时间复杂度是
    //O（n），但为什么LeetCode上的时间花销竟然只能击败26%的人，我都没有用递归...蓝瘦
    public Node connect(Node root) {
        Queue<Node> queue=new LinkedList<>();
        Node p;
        if(root==null)
            return root;
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            //当队列里只有一个结点的时候，就是只有根节点，无需理会next指针
            if(size==1){
                p=queue.remove();
                if(p.left!=null){
                    queue.add(p.left);
                    queue.add(p.right);
                }
                continue;
            }
            //遍历当前层的树节点，每一层的最后一个结点前都把next指针指向右邻结点
            for(int i=0;i<size;i++){
                p=queue.remove();
                if(i!=size-1){
                    p.next=queue.element();
                }
                if(p.left!=null){
                    queue.add(p.left);
                    queue.add(p.right);
                }
            }
        }
        return root;
    }
}
