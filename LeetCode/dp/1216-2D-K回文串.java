//这题我本来是想用dp[i][j]表示[i,j]是否为k回文串，构建当前状态，当首尾相等，则判断dp[i+1][j-1]，否则删头或者删尾，base case是：start>=end 则返回true，k==0，则判断当前[i,j]是否为回文
//但是不知道哪出问题，卡了一个test case
//只能用删除n个字符后成为回文串，最后判断n是否不大于k

class Solution {
    private Integer[][] dp;
    private String s;
    public boolean isValidPalindrome(String s, int k) {
        this.s=s;
        int n=s.length();
        dp=new Integer[n][n];
        return dfs(0,n-1)<=k;
    }

    private int dfs(int start,int end){

        if(start>=end){
            return 0;
        }
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        int res;
        if(s.charAt(end)==s.charAt(start)){
            res=dfs(start+1,end-1);
        }else{
            res=Math.min(dfs(start,end-1),dfs(start+1,end))+1;
        }
        return dp[start][end]=res;
    }
}
