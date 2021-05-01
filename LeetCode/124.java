//第一思路，DFS，这个问题如果只计算孩子节点的最长路径是不够的，因为有可能最长路径不经过根节点，因此需要一个全局变量来维护最大路径；
// DFS的子状态就是每个孩子节点都返回自己的最长路径，该路径是可以给父节点使用的；每个节点的需单独计算一下该节点下的最长路径并更新到全局变量中

class Solution {
    int gMax;
    public int maxPathSum(TreeNode root) {
        gMax=-1001;
        getMax(root);
        return gMax;
    }
    
    private int getMax(TreeNode root){
        if(null==root)return 0;   //返回0
        int maxL=Math.max(0,getMax(root.left));   // 左子树的最长path和，和0比较取最大值，因为小于0的不须计算
        int maxR=Math.max(0,getMax(root.right));
        gMax=Math.max(maxL+maxR+root.val,gMax);   //单独计算下该节点下的path和
        return Math.max(maxL,maxR)+root.val;      //返回可供给父节点使用的path
    }
}

//本思路难点在于，区分清楚子状态和某节点的最长path和，子状态是需要返回给父节点使用的，因此不能是左右子树都用上；相反当前节点下的最长path不一定只能是一个子树和当前节点的和，
//因此需要相加起来并更新到全局变量中。也就是最长的path和需要子状态和额外操作来过滤出来。
