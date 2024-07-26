//有点难想出来，没有找到子状态。bottom up，可以让子树返回它们的coins数量，如果多了x，则步数就是要x，如果少了y，则步数则是y，然后建立当前的状态，就是x+y+root-1，（给root留一个coin）
//这个关键就是如何利用子状态，想到abs(excess)是步数也是关键点，然后问子树要答案，把子树的步数累加，就是当前的步数，最后返回步数




class Solution {
    private int steps=0;
    public int distributeCoins(TreeNode root) {
        int plus=getSteps(root);
        return steps;
    }
    
    public int getSteps(TreeNode root){
        if(root==null)return 0;    
        int L=getSteps(root.left);
        int R=getSteps(root.right);
        steps+=Math.abs(L)+Math.abs(R);
        return L+R+root.val-1;
    }
    
}
