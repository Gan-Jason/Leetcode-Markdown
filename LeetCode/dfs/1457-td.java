//本题的关键在于找到判断是否能组成回文的条件：一组数字中，出现频率为奇数次的数字不能大于一个，如果超了就不符合回文要求
//根据判断条件去实现其实挺简单了，但是我实现了半天，是因为睡了一觉吗？
//我出问题的点是，回溯的时候如何删掉本层节点出现次数（我把次数的减少做成了移除节点值。。，导致祖先节点也被移除了）
//因为本题会出现一个情况，叶子节点时会进行两次本路径的回文检查，如果不进行条件判断而是直接在root==null的时候判断的话
//应该是在left==null&&right==null的时候判断
//本题用map的话性能较差，如果直接用list会快一点，list下标为节点值，内容为出现频率
//如果用hashset会更快：如果set中不存在val，则加入；如果存在则移除。最后判断set的长度，从而得到path中出现奇数次的节点数

class Solution {
    private int ans=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root,new HashMap<Integer,Integer>());
        return ans;
    }
    
    private void dfs(TreeNode root,Map<Integer,Integer> path){
        if(root==null)return;
        path.put(root.val,path.getOrDefault(root.val,0)+1);   //先加入root的次数
        if(root.left==null&&root.right==null){      //判断本path是否符合条件
            int fre=0;
            for(Integer key:path.keySet()){
                if(path.get(key)%2!=0){
                    fre++;
                }
                if(fre>1){
                    break;
                }
            }
            ans+=(fre>1?0:1);
        }
        
        dfs(root.left,path);
        dfs(root.right,path);  
        path.put(root.val,path.get(root.val)-1);    //回溯时，不要搞错条件，不是移除节点，而是减少出现次数
    }
    
}
