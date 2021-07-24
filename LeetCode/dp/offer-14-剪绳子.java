//这题也是典型的dp，但是要注意的是，用bottom up的方式的话，剪了一刀之后，问子问题要答案；而不是剪完一刀还要找这一刀的答案，这一刀已经是不可切分了
//还有一点注意的，如果是第一刀，则必须剪一刀，如果剪过一刀了，则只需要找到最长的乘积和即可，
//注意base case
class Solution {
    private Integer[] dp; 
    public int cuttingRope(int n) {
        this.dp=new Integer[n+1];
        return dfs(n,1);
    }

    private int dfs(int n,int m){
        if(n==0){   //base case
            return 0;
        }
        if(n==1){     //注意n==1可以直接判断，但是n==2不能直接判断，因为不知道是不是需要剪的，如果不需要剪则最大是2，如果需要剪则为1
            return 1;
        }
        if(dp[n]!=null){
            return dp[n];
        }
        int ans=-1;
        for(int i=1;i<n;i++){
            if(m==1){   //当前还没剪过，则必须剪一刀
                ans=Math.max(i*dfs(n-i,0),ans);
            }else{
                int mul=Math.max(n,i*dfs(n-i,0));   //如果已经剪过了，则判断剪的收益大，还是不剪的收益大：n表示不剪，dfs(n-i)表示从i处剪一刀
                ans=Math.max(mul,ans);
            }
        }
        return dp[n]=ans;
    }
}
