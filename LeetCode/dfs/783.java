//看到题目思路很清晰，BST的中序是有序递增序列，因此在一个有序的序列里，相邻的两个数的差是最小的，所以只需要在中序遍历中做差值找出最小的即可，时间复杂度是o(n)
//但是，实现过程中遇到一点卡顿，就怀疑自己，并开始想别的思路，导致耗时较长，卡住的地方是遍历第一个节点时，如何做与前一个的差值并取于目前的min比较后最小的值
//绕了一点弯路后，想到可以初始化一个很大的数作为min的初始值，pre也是，第一个节点后，pre就可以正常赋值为前一个，min的比较也正常



class Solution {
    private int minDiff=Integer.MAX_VALUE;
    private int pre=Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return minDiff;
    }
    
    public void dfs(TreeNode root){
        if(root==null)return;
        dfs(root.left);
        minDiff=Math.min(minDiff,Math.abs(root.val-pre));
        pre=root.val;
        dfs(root.right);
    }
}
