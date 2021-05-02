//1. DFS，一开始我的思路是bootom up，但是运行后发现只能bp判断一个两层子树的平衡情况，无法判断根节点和子树的情况，然后我想把子树的最小节点和最大节点返回上来与根节点比较，但是这么做无法
//判断是否为最小和最大的节点。
// 转变思路为top down，但是找不到子状态，也就是想不到如何把根节点的状态传下去，从而判断子树是否符合
//如果用max和min传值下去，则左子树中，最大值将是根节点的值，右子树中，最小值就是根节点的值，每一个节点都在(min,max)范围内

public class Solution {
    public boolean isValidBST(TreeNode root) {
        return BST(root,Long.MAX_VALUE,Long.MIN_VALUE);           //
    }
    
    public boolean BST(TreeNode root,long max,long min){          //用max和min来把根节点的极值传下去
        if(root==null)return true;
        if(root.val<=min||root.val>=max)return false;
        return BST(root.left,root.val,min)&&BST(root.right,max,root.val);     //如果是左子树，则最大值就是根节点的值，如果是右子树，则最小值就是根节点的值；
                                                                              //并且把上一层的max或者min都传下去了，因此这个范围是更新，但始终是根节点的范围子集
    }
}
