//字典序排数，可以用十叉树来做，然后dfs遍历
//但是第一层只有9个节点，之后每个节点有十个孩子节点

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans=new ArrayList<>(n);
        for(int i=1;i<=9;i++){    //第一层遍历
            dfs(ans,i,n);
        }
        return ans;
    }

    private void dfs(List<Integer> ans,int num,int n){
        if(num>n){    //base case
            return;
        }
        ans.add(num);   //当前层的选择，从第一层开始
        num*=10;    //下一层的数量级
        for(int i=0;i<10;i++){    //遍历孩子节点
            dfs(ans,num+i,n);   //深度优先
        }
    }
}
