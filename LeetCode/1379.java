// 这题出的不太好，DFS,BFS都可以快速解答

// 1. DFS,时间复杂度这个较小
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return getNode(cloned,target.val);
        
    }
    
    TreeNode getNode(TreeNode root,int target){
        if(root==null)return null;
        if(root.val==target)return root;
        TreeNode lNode=getNode(root.left,target);
        if(lNode!=null)return lNode;
        TreeNode rNode=getNode(root.right,target);
        return rNode;
    }
}

//2. BFS,
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned==null)return target;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(cloned);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.val==target.val)return cur;
            if(cur.left!=null)queue.offer(cur.left);
            if(cur.right!=null)queue.offer(cur.right);
        }
        return null;
        
    }
}
