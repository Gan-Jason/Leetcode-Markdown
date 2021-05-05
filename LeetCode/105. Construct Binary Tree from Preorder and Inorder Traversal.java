/**
  *
  * Given preorder and inorder traversal of a tree, construct the binary tree
  * 1. 本题19年做过一次，今天是20210505，劳动节放假
  * 2. 本题思路是分治法，找到问题的子状态/子问题，递归解决问题，应该是属于数组类型，当前序和中序的长度为1时，树的根节点就是唯一这个节点；前序的第一个节点都是树/子树的根节点，
  * 在中序序列中找到根节点所在位置，根节点的左侧是左子树，右侧是右子树 ，然后递归进行
  * 3. 优化：递归时，传入的前序和中序可以是原数组，只要找到定义本次序列的位置即可，即便是只有一个前序序列也是可以的，因为它包含了所有节点，只需要找到划分左右的下标。
  * 因此，空间上优化是用原来的数组，传参下标；先在第一次遍历，在原中序中找到所有前序根节点的下标并保存在map中，方便使用，取出时时间花销为常数，递归时，只用前序序列以及相应的下标
  * 4. 还有一点，数组找下标问题，要透过问题看本质，理解这个下标的含义再用相应的变量去表示它，比如前序中的下标，是根据中序的下标走过的长度确定的，故前序的下标就是inlength-prestart
  * 不能没有根据的乱写，否则在边界会有问题。
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
 * 2019/09
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



class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=build(preorder,inorder,0,0,inorder.length-1);
        
        return root;
    }
    
    public TreeNode build(int[] preorder,int[] inorder,int preStart,int inStart,int inEnd){
        if(inStart>inEnd)return null;
        if(inStart==inEnd){
            return new TreeNode(preorder[preStart]);
        }
        TreeNode root=new TreeNode(preorder[preStart]);
            for(int j=inStart;j<=inEnd;j++){
                if(inorder[j]==preorder[preStart]){
                    root.left=build(preorder,inorder,preStart+1,inStart,j-1);
                    root.right=build(preorder,inorder,preStart+j+1-inStart,j+1,inEnd);
                    break;
                }
            }
        return root;

        
    }
    
}

