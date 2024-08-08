/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode head;  //为了遍历链表，需要定义一个全局变量
    //根据链表中序列构造二叉平衡树
    //因为该序列是有序的，故可发现是二叉平衡树的中序遍历结果，所以可以根据中序遍历的思想来递归建树
    //1.首先找到链表的中间节点的索引，可以由mid=（left+right）/2得到，所以还需要得到链表的长度
    //2.中序遍历是先递归左子树，在处理节点，最后递归右子树
    //3.链表的最左端的节点即是二叉平衡树的最左下的叶子节点
    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root=null;
        if(head==null)
            return root;
        this.head=head;
        root=buildBST(0,getSize(this.head)-1);
        return root;

    }
    private TreeNode buildBST(int left,int right){
        TreeNode root=null;
        if(left>right)
            return root;
        int mid=(left+right)/2;
        //先递归左子树
        TreeNode left_child=this.buildBST(left, mid-1);
        //此时构造最左下的叶子结点，值为链表第一个结点值
        root=new TreeNode(this.head.val);
        //根节点的左节点为刚才构造的叶子节点
        root.left=left_child;
        //链表遍历下一个
        this.head=this.head.next;
        //递归右子树
        root.right=this.buildBST(mid+1, right);
        //root.right=right_child;
        
        return root;

    }
    private int getSize(ListNode head){
        int length=0;
        while(head!=null){
            head=head.next;
            ++length;
        }
        return length;
    }
}


// 2024.7.30

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int[] ary = new int[20000];
        int i = 0;
        while (head != null) {
            ary[i++] = head.val;
            head = head.next;
        }
        return build(ary, 0, i - 1);
    }

    public TreeNode build(int[] ary, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (end + start) >> 1;
        TreeNode root = new TreeNode(ary[mid]);
        root.left = build(ary, start, mid - 1);
        root.right = build(ary, mid + 1, end);
        return root;
    }
}