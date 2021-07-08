//回文序列比回文子串要简单一点，s[i]==s[j]后因为不需要判断内子串是否是回文。只需要继续往里面找回文序列并累加长度即可。
//注意一点，当正向填表时。行（i）不能从0开始，因为从0开始的话，后面有些子问题还没计算到，而我们需要的答案就是s[0][len-1]；应该是从子问题答案递推大问题答案，因此要先算小的
//从后面开始算

class Solution {
    private Integer[][] dp;
    private String s;
    public int longestPalindromeSubseq(String s) {
        this.s=s;
        int m=s.length();
        // this.dp=new Integer[m][m];
        // return dfs(0,m-1);
        int[][] dp=new int[m][m];
        int ans=0;
        for(int i=0;i<m;i++){
            dp[i][i]=1;
        }
      //从倒数第二个位置的子串开始算，该串的最长子序列
        for(int i=m-2;i>=0;i--){
            for(int j=i+1;j<m;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
                ans=Math.max(dp[i][j],ans);
            }
        }
        if(ans==0&&m>0){
            ans=1;
        }
        return ans;
    }

    private int dfs(int start,int end){
        if(start<=end&&dp[start][end]!=null){
            return dp[start][end];
        }
        if(start==end){
            return 1;
        }else if(start>end){
            return 0;
        }
        int res=0;
        if(s.charAt(start)==s.charAt(end)){
            res=2+dfs(start+1,end-1);
        }else{
            res=Math.max(dfs(start,end-1),dfs(start+1,end));
        }
        return dp[start][end]=res;
    }
}
