//最短下降路径，从bottom up去思考比较容易找到思路：求到达matrix[m-1][n-1]最短下降路径，即求matrix[m-1][n-1]+Math.min(dp[m-2][n],dp[m-2][n+1],dp[m-2][n-1])的值
//即问子问题要答案
//这里要注意的是，求最后一行的某个位置的最短下降路径，只能的到涉及本位置的dp子问题答案，其余的未计算。因此要在最后一行进行一个forloop，找到本行中所有位置的下降路径，才能计算所有子问题

class Solution {
    private int ans;
    private Integer[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        ans=2147483647;
        dp=new Integer[n][n];
        int res=0;
        for(int i=n-1;i>=0;i--){
            res=dfs(matrix,n-1,i);
            ans=Math.min(ans,res);
        }
        return ans;
    }
    private int dfs(int[][] matrix,int m,int n){
        if(m==0){
            return matrix[m][n];
        }
        if(dp[m][n]!=null){
            return dp[m][n];
        }
        int res=0;
        if(n==matrix.length-1){
            res+=matrix[m][n]+Math.min(dfs(matrix,m-1,n),dfs(matrix,m-1,n-1));
        }else if(n==0){
            res+=matrix[m][n]+Math.min(dfs(matrix,m-1,n),dfs(matrix,m-1,n+1));
        }else{
            res+=matrix[m][n]+Math.min(Math.min(dfs(matrix,m-1,n),dfs(matrix,m-1,n-1)),dfs(matrix,m-1,n+1));
        }
        return dp[m][n]=res;
    }

}
