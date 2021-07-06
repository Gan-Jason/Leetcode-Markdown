//很惊喜，最后瞎写反而通过了
//首先是回溯，超时了
//然后dp，但是没找到子问题，没找到边界条件；
//重要的就是找子问题，然后找边界条件，根据边界条件构造/递推各子问题答案。
//这题的边界条件就是，String s，String t，当t的长度为0时，答案（子序列的长度）为1，因为空串是任何字符串的子序列，任何字符串有且只有一个子序列是空串；当s的长度比t小时，答案为0，
//子序列长度不可能比原字符串长
//然后求子问题答案，构建当前问题答案：设i=sLength,j=tLength,bootom up,
//1. 如果s[i]==t[j]，那么：当前答案就是res=dfs(i-1,j-1)+dfs(i-1,j);因为当前位置字符相等的话
//既可以问s[i-1],t[j]要答案，也可以问s[i-1],t[j-1]，t的当前位置可选，可不选，这就解决了我一开始想用循环找到t当前位置所有可能的问题；
//2. 如果s[i]!=t[j]，那么只能问s[i-1],t[j]要答案了
class Solution {
    private int ans;
    private String s;
    private String t;
    private Integer[][] dp;
    public int numDistinct(String s, String t) {
        this.s=s;
        this.t=t;
        int m=s.length();
        int n=t.length();
        dp=new Integer[m][n];
        dfs(m-1,n-1);
        return dp[m-1][n-1];
    }

    private int dfs(int m,int n){    
        if(n<0){    //空串是任何字符串的子串
            return 1;
        }
        if(m<0){    //边界
            return 0;
        }
        if(m<n){    //特殊情况
            return dp[m][n]=0;
        }
        if(dp[m][n]!=null){
            return dp[m][n];
        }
        int res=0;
        if(s.charAt(m)==t.charAt(n)){
            res+=dfs(m-1,n-1)+dfs(m-1,n);
        }else{
            res+=dfs(m-1,n);
        }
        return dp[m][n]=res;
    }
}
