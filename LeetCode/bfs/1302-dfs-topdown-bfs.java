//这题可以用bfs或dfs。我第一思路是既然关于层数/深度的，用bfs可能会想出思路快一点。关键点是如何保存最大层数的叶子节点之和。我第一次使用map保存每层叶子节点的和，key是叶子层数，value是该层
//的节点和，并记录最大层数，但是这样会浪费空间，时间性能也挺低
//改用dfs，top down，向下传当前level，如果当前是叶子节点则累加，并根据level判断是否要更新sum，如果是level比maxLevel大，则重置sum并重新累加。先序遍历可保证叶子节点从左到右顺序
//如果都不用map，同样是o(n),dfs比bfs要快一点，因为bfs要维护一个queue


class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root==null)return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int level=0,maxLevel=0;
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            level++;
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur.left==null&&cur.right==null){          //其实这里不必要用map，用sum保存也可以，参照下面方法，
                    maxLevel=Math.max(maxLevel,level);
                    map.put(level,map.getOrDefault(level,0)+cur.val);
                }
                if(cur.left!=null)queue.offer(cur.left);
                if(cur.right!=null)queue.offer(cur.right); 
            }
        }

        return map.get(maxLevel);
        
        
    }
}

class Solution {

    int maxLevel=0;
    int ans=0;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return ans; 
    }
    
    public void dfs(TreeNode root,int level){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            if(level==maxLevel){
                ans+=root.val;
            }
            else if(level>maxLevel){
                ans=0;
                ans+=root.val;
                maxLevel=level;
            }
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
    
}
