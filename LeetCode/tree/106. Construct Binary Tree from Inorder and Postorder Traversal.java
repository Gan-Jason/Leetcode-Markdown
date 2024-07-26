/**
* Given inorder and postorder traversal of a tree, construct the binary tree.
*
*
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
    //根据中序序列和后序序列构造二叉树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode head=null;
        head=recursiveBuildTree(postorder.length-1,0,inorder.length-1,inorder,postorder);
        return head;

    }   
    //root_index是后序序列中根节点的下标，因为二叉树的后序序列中，最后一个节点值就是根节点的值，故可根据每一个后序序列的最后一个值来确定根节点
    //确定根节点后，在中序序列中找出根节点的值，找出中序的根节点后，在中序中，根节点左边就是树的左子树，根节点的右边就是树的右子树
    //start 和end 分别是中序序列的开始端和结束端，递归只需要传入新序列的两端即可，节省了空间开销
    public TreeNode recursiveBuildTree(int root_index,int start,int end,int[] inorder,int[] postorder){
        TreeNode head=null;
        //当中序序列长度为零是结束递归，或者后序的节点遍历结束时
        if(start>end||root_index<0)
            return head;
        //中序中只有一个节点值
        else if(start==end)
            return new TreeNode(inorder[start]);
        head=new TreeNode(postorder[root_index]);
        //找出中序中根节点的位置
        int temp_root_index=Solution.indexOfNumber(inorder, postorder[root_index]);
        //根节点的右子树的根节点是紧靠在根节点的左边的，每下一个就往左移一位
        head.right=recursiveBuildTree(root_index-1, temp_root_index+1, end, inorder, postorder);
        //根节点的左子树的根节点是遍历完右子树的根节点后再往左遍历而得
        head.left=recursiveBuildTree(root_index-end+temp_root_index-1, start, temp_root_index-1, inorder, postorder);
        return head;
    }
    static int indexOfNumber(int[] ary,int target){
    if(ary.length==0)
        return -1;
    for(int i=0;i<ary.length;i++){
        if(ary[i]==target)
            return i;
    }
    return -1;
}
}
