//这个题，我的思路是正确的， 但是实现上有问题，Java中参数传递都是拷贝引用或者拷贝值，因此直接对引用操作（置空或者重指向）是影响不了传递前的对象，只能对拷贝引用指向的对象的值改变。
//比如说，root=null;//无效,root此时只是一个拷贝的引用，这个操作相当于给这个新的引用指向null，root.left=null;//有效，root此时还是指向原对象（堆中），
//因此可以改变原堆中的对象内容并生效,说明堆也是保存引用的--对象内的引用变量
//所以本题的关键是如何删除节点，通过bottom up，把root的左右子树结果传回来，构造当前root引用的左右子树

class Solution {
    private List<TreeNode> ans;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<to_delete.length;i++){
            map.put(to_delete[i],1);
        }
        TreeNode r=dfs(root,map);
        if(r!=null)
            ans.add(r);
        return ans;
    }
    
    private TreeNode dfs(TreeNode root,Map<Integer,Integer> d){
        if(root==null)return null;
        root.left=dfs(root.left,d);
        root.right=dfs(root.right,d);
        if(d.get(root.val)!=null){
            if(root.left==null&&root.right==null){
                return null;
            }
            if(root.left!=null){
                ans.add(root.left);
            }
            if(root.right!=null){
                ans.add(root.right);
            }
            root=null;
        }
           return root;
        
    }
}
