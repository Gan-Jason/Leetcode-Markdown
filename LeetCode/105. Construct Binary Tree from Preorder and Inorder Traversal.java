/**
  *
  * Given preorder and inorder traversal of a tree, construct the binary tree
  *
  *
  /
  
  
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    //根据二叉树的前序遍历结果和中序遍历结果确定一棵二叉树并构造出来
    //我用的是递归的思想，前序顺序中，在一个序列里第一个就是根节点，在中序序列里，根节点右边都是根节点的右子、孙，同理根节点左边都是子孙
    //所以我们就递归每一个前序中的根节点和中序中的左右节点
        TreeNode head=null;
        head=recursiveBuildTree(head,preorder,inorder);
        return head;

    }          
    private TreeNode recursiveBuildTree(TreeNode head,int[] preorder,int[] inorder){
        //中序数组和前序数组是相同的元素，只是顺序不同，当其中一个长度为零时，递归结束
        if(preorder.length==0)
            return head;
        else if(preorder.length==1){
            head=new TreeNode(preorder[0]);
            return head;
        }
        //构造树得根节点
        head=new TreeNode(preorder[0]);
        //找到根节点的中序的位置
        int head_index=indexOfNumber(inorder,preorder[0]);
        //把根节点左右儿子节点的数组都构造出来了，其实不用浪费多余的空间，利用原数组的空间即可，这里只需要传入 开始和结束的位置，即可
        int[] temp_right_inorder=Arrays.copyOfRange(inorder, head_index+1,inorder.length);
        int[] temp_right_preorder=Arrays.copyOfRange(preorder, head_index+1, preorder.length);
        int[] temp_left_preorder=Arrays.copyOfRange(preorder,1, head_index+1);
        int[] temp_left_inorder=Arrays.copyOfRange(inorder, 0, head_index);
        //递归根节点的左右孩子节点
        head.left=recursiveBuildTree(head.left, temp_left_preorder, temp_left_inorder);
        head.right=recursiveBuildTree(head.right, temp_right_preorder, temp_right_inorder);
        return head;
            
    }
    //找出数组的数字的位置
    private int indexOfNumber(int[] ary,int target){
        if(ary.length==0)
            return -1;
        for(int i=0;i<ary.length;i++){
            if(ary[i]==target)
                return i;
        }
        return -1;
    }

}
