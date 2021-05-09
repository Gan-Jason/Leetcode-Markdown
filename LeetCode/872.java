//1. 目前easy是挺快有思路的，但是会纠结，是不是比较良好的时间开销，容易陷入找最优解变成最优雅解，其实只要时间复杂度不是n平方，就可以先解题
// 一开始思路是dfs找叶子节点，然后用数组保存，最后比较两个数组，这也是最简单的思路，但是开始的时候纠结于怎么一次性遍历完两个树，这里有个问题，就是两棵不同结构的树想要同时dfs是比较困难的
//思路实现第一次用了queue，没有必要，queue会出问题，具体是什么没找出来，当测试用例很长的时候报错
//时间复杂度o（n1+n2）

class Solution {
    List<TreeNode> q1=new ArrayList<>();
    List<TreeNode> q2=new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        dfs(root1,q1);
        dfs(root2,q2);
        if(q1.size()!=q2.size())return false;
        for(int i=0;i<q1.size();i++){
            if(q1.get(i).val!=q2.get(i).val)return false;
        }
        return true;
    }
    public void dfs(TreeNode root,List<TreeNode> q){
        if(root==null)return;

        if(root.left==null&&root.right==null){
            q.add(root);
        }

        dfs(root.left,q);
        dfs(root.right,q);
    }
    
    
    
}
