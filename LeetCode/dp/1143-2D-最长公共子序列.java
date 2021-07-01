// 子问题是指比原问题规模小的相同问题，重复子问题是指在计算过程中有重复计算的情况，规模一样、答案一样的子问题。
// 两个Array/String 肯定是2D的dp
// 用bootom up的dfs思路去想，会比较直观，top down是for-loop，计算逻辑和bottom up是一样的
//先解决问谁要答案构建当前问题的状态，再解决边界问题

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[1+m][1+n];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
