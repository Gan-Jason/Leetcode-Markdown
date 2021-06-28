//直接把n丢进去，从i=1开始拆，算出每个n-i的最大乘积和，并用dp记录已经计算过的子问题
//注意点：当拆分的子项大于一项时，不一定需要拆分了，可以直接用该n，所以要把拆分后的乘积结果和不拆分的直接相乘结果比较，取较大值

class Solution {
    private int[] dp;   //定义dp
    public int integerBreak(int n) {
        if(n<=2){
            return 1;
        }
        this.dp=new int[n+1];
        return dfs(n,0);
    }
    private int dfs(int n,int count){   //count用于记录已拆分的子项
        if(dp[n]!=0){   //计算过了
            return dp[n];
        }
        int ans=0;
        for(int i=1;i<n;i++){   //从i=1开始拆分
            int res=i*dfs(n-i,count+1); //问子问题要答案
            ans=Math.max(ans,res);    //更新答案
        }
        if(count>=2){   //当拆分项大于等于2时，可以直接相乘，也可以继续拆分
            ans=Math.max(n,ans);
        }
        return dp[n]=ans;     //更新当前状态
    }
}
