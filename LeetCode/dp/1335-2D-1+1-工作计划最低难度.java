//这题也是需要循环找当前状态的最优解，设当前状态，即当天计划做k项工作，则子问题则是dp[n-k,d-1],如果子问题不成立，则当前的也不成立
//这题正向dp没做出来，卡在细节上了

class Solution {
    private Integer[][] dp;
    private int[] job;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n=jobDifficulty.length;
        this.job=jobDifficulty;
        dp=new Integer[n+1][d+1];
        return dfs(0,n,d);
        // int[][] dp=new int[n+1][d+1];
        // for(int i=1;i<=n;i++){
        //     int max=-1;
        //     int j=0;
        //     while((max=Math.max(max,jobDifficulty[j]))>0&&++j<i);
        // }
    //     for(int i=1;i<=n;i++){
    //         for(int j=1;j<=d;j++){
    //             int left=2147483647;
    //             for(int k=1;k<i;k++){
    //                 int max=-1;
    //                 int p=i-k-1;
    //                 while((max=Math.max(max,jobDifficulty[p]))>0&&++p<i);
    //                 left=Math.min(dp[i-k-1][j-1]+max,left);
    //             }
    //             dp[i][j]=left==2147483647?-1:left;
    //         }
    //     }
    //     return dp[n][d];
    }
    //bootom up
    private int dfs(int start,int n,int d){
        if(d>n){
            return -1;
        }
        if(n==1){
            return job[start];
        }
        if(d==1){
            int max=0;
            for(int j=start;j<n+start;j++){
                max=Math.max(max,job[j]);
            }
            return max;
        }
        if(dp[n][d]!=null){
            return dp[n][d];
        }
        int res=2147483647;
        for(int i=1;i<=n;i++){
            int right=dfs(start+i,n-i,d-1);
            if(right!=-1){
                int max=0;
                for(int j=start;j<start+i;j++){
                    max=Math.max(max,job[j]);   //找出当天的工作难度，取工作项中最大的难度
                }
                int ans=max+right;    //计算当前状态的答案
                res=Math.min(res,ans);  //取最优解
            }
        }
        return dp[n][d]=res;
    }
}
