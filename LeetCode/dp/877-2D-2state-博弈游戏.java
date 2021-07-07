//这个一维数组是不能用双指针的，因为得记录每次选择的结果，最后做比较；而且用贪心也不行，不知道里面会不会有更大的；
//因此需要记忆每次的选择，并且会有重复子问题，因此用dp
//画出递归树，每次选择完剩余的数组，发现可以用下标表示剩下的东西，比如dp[i][j]表示剩下从i到j的石头堆，从这些石头堆里面找答案，而当前状态/问题的答案建立于此：
//dp[i][j]=piles[i]-dp[i+1][j]，或者dp[i][j]=piles[j]-dp[i][j-1]，取二者较大者；含义就是每次可以取第一堆或者最后一堆，当前问题答案就是用取了的石头减去子问题的答案。
//因为下一堆就是对手拿的结果

class Solution {
    // private Integer[][] dp;
    // private int[] piles;
    public boolean stoneGame(int[] piles) {
        int m=piles.length;
        this.piles=piles;
        this.dp=new Integer[m][m];
        // return dfs(0,m-1)>0;
        for(int i=0;i<m;i++){
            dp[i][i]=piles[i];
        }

        for(int i=m-2;i>=0;i--){
            for(int j=i+1;j<m;j++){
                dp[i][j]=Math.max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
            }
        }
        return dp[0][m-1]>0;
    }
  //dfs，bottom up
    // private int dfs(int start,int end){
    //     if(start==end){
    //         return piles[start];
    //     }
    //     if(dp[start][end]!=null){
    //         return dp[start][end];
    //     }
    //     int first=dfs(start+1,end);
    //     int last=dfs(start,end-1);
    //     return dp[start][end]=piles[start]-first>piles[end]-last?piles[start]-first:piles[end]-last;
    // }
}
