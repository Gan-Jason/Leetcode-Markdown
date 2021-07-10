//动态规划，一定要分为当前问题和子问题两个部分，利用子问题答案构造当前问题答案
//因此画递归树的时候，就要先处理当前问题的状态，只考虑当前问题，
//这里的当前问题就是，原字符串的首尾是否相等，如果相等，当前就不用做处理，只需要问子问题要答案；如果不想等，则需要处理：
//在头部添加尾部的字符，或者在尾部添加头部的字符，则子问题分别就是:dp[i][j-1]和dp[i+1][j]，因为添加字符的一侧，下个子问题还是以原来的位置作为范围；当前问题的状态就是1+子问题答案，因为
//当前做了处理，加上处理次数1

class Solution {
    private String s;
    private Integer[][] dp;
    public int minInsertions(String s) {
        this.s=s;
        int m=s.length();
        // this.dp=new Integer[m][m];
        // return dfs(0,m-1);
        int[][] dp=new int[m][m];
      //递推填表
        for(int i=m-2;i>=0;i--){
            for(int j=i+1;j<m;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][m-1];


    }
  //递归填表
    private int dfs(int start,int end){
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        if(start>=end){
            return 0;
        }
        int res=0;
        if(s.charAt(start)==s.charAt(end)){
            res=dfs(start+1,end-1);
        }else{
            res=1+Math.min(dfs(start,end-1),dfs(start+1,end));
        }
        return dp[start][end]=res;
    }

}
