//这一题我用了两个递归，（一个计算给定root的节点和，一个计算左右子树差值）性能低，本题可以在一个递归中计算两个值，1.做左右子树的sum差值，2.返回本树的节点和
//本题的o(n)可以是bottom up（后序遍历获得左右子树的值，做计算）

public class Solution {
    int result = 0;
    
    public int findTilt(TreeNode root) {
        postOrder(root);
        return result;
    }
    
    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        
        int left = postOrder(root.left);      //bottom up，利用下面传上来的值
        int right = postOrder(root.right);
        
        result += Math.abs(left - right);     //左右做差并累加，
        
        return left + right + root.val;       //返回本树节点和
    }
}


class Solution {      //我的笨方法
    private int ans=0;
    
    public int findTilt(TreeNode root) {
        if(root==null)return 0;
        ans+=Math.abs(dfs(root.left)-dfs(root.right));    //递归嵌套递归
        if(root.left!=null)
            findTilt(root.left);
        if(root.right!=null)
            findTilt(root.right);
        return ans;  
    }

    
    int dfs(TreeNode root){
        if(root==null)return 0;
        return root.val+dfs(root.left)+dfs(root.right);
    }
    
    
    
}
