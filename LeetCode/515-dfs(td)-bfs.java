//只要保存每层的最大节点值即可，一开始用错数据结构，用了map，map较为易理解
//用list保存的话，index就是层数，遍历到每层的一个新节点都去更新一下list，如果有改层（depth<size），则取最大值，如果没有这一层，则直接add


class Solution {
    private List<Integer> ans;
    public List<Integer> largestValues(TreeNode root) {
        ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        ans.add(root.val);
        dfs(root,0);
        return ans;
    }
    
    private void dfs(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(depth<ans.size()){
            int t=ans.get(depth);
            ans.set(depth,Math.max(root.val,t));
        }else{
            ans.add(root.val);
        }

        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}
