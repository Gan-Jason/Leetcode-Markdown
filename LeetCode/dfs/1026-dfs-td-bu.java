//本题用了暴力解，全部遍历一边，把root-path的路径保存了下来，然后每一个节点都for循环做一次差值并取最大值。。，时间复杂度o（n）
//尝试follow up，但是想的太复杂，不够清晰，没找到关键点，
//关键点就是，一个path上，只要找到最大值，最小值，最大的差值就出来了。。
//这样的话，既可以top down，一边和max和min做差值取最大值，一边传max和min下去
//也可以bottom up，，吧max和min记下来，并一直递归到null，即path的尽头，再做max-min的差值并返回，最后时left和right取最大值。（root节点就两个分支，即两个path）


class Solution {
    private int maxDiff=0;
    public int maxAncestorDiff(TreeNode root) {
        //dfs(root,new ArrayList<Integer>());
        helper(root,root.val,root.val);
        return maxDiff;
    }
    
    private void dfs(TreeNode root,List<Integer> path){
        if(root==null)return;
        for(int i=0;i<path.size();i++){
            maxDiff=Math.max(maxDiff,Math.abs(path.get(i)-root.val));
        }
        path.add(root.val);
        dfs(root.left,path);
        dfs(root.right,path);
        path.remove(path.size()-1);
    }
    
    private void helper(TreeNode root,int max,int min){
        if(root==null)return;
        max=Math.max(root.val,max);
        min=Math.min(root.val,min);
        maxDiff=Math.max(maxDiff,Math.abs(root.val-max));
        maxDiff=Math.max(maxDiff,Math.abs(root.val-min));
        helper(root.left,max,min);
        helper(root.right,max,min);
    }
    
    
}
