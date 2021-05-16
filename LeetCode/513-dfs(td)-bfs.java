//dfs:找到最长路径，答案就是该路径的叶子节点
//bfs，每层从右往左遍历，层次遍历结束后，最后一个节点就是答案



class Solution {
    int max=0;
    int ans;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,new ArrayList<Integer>());
        return ans;
    }
    private void dfs(TreeNode root,List<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.val);
        if(root.left==null&&root.right==null){
            if(path.size()>max){
                ans=path.get(path.size()-1);
                max=path.size();
            }
        }
        
        dfs(root.left,path);
        dfs(root.right,path);
        path.remove(path.size()-1);
    }
    public int findLeftMostNode(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        root = queue.poll();
        if (root.right != null)
            queue.add(root.right);
        if (root.left != null)
            queue.add(root.left);
    }
    return root.val;
}
}

//优化的dfs，不需要记录路径，反正只要知道最大的depth就可以了啊！为什么要多此一举。
class Solution {
    int max=-1;
    int ans;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return ans;
    }
    private void dfs(TreeNode root,int path){
        if(root==null){
            return;
        }
        if(path>max){
            ans=root.val;
            max=path;
        }
        dfs(root.left,path+1);
        dfs(root.right,path+1);
    }
    
}



