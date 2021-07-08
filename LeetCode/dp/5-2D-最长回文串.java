//双指针法是可以，但是超时了，因为双指针不能简单找到第一个首尾相等的子串，还要继续找指针内部是否有相等的，需要记住一些子答案，否则会超时
//暴力法也可以，就是枚举所有的子串，每一次枚举都判断一下是否是回文，枚举可以用长度枚举，也可以用下标。
//涉及重复子问题的都是dp，这里是双指针，因此是2D，
//我尝试用dp记录(i,j)的最长回文串，但是有些位置没有填到，使用dp数组时导致空指针异常；dfs的dp应该返回什么，dp就用什么
//首先先确认一件事，s[i]==s[j]且s(i+1,j-1)是回文串才是回文串。因此需要dfs判断s(i+1,j-1).即返回boolean。ans在确认是回文时更新
class Solution {
    //双指针超时了，因为双指针不能简单找到第一个相等的，还要继续找指针内部是否有相等的，需要记住一些子答案，否则会超时
    // 
    //     int m=s.length();
    //     String ans="";
    //     int sum=0;
    //     for(int i=0;i<m;i++){
    //         int p=m-1;
    //         while(i<p){
    //             int j=p;
    //             while(j>i&&s.charAt(i)!=s.charAt(j)){
    //                 j--;
    //             }
    //             p=j-1;
    //             if(i!=j&&s.charAt(i)==s.charAt(j)){
    //                 int k=i;
    //                 int t=0;
    //                 while(k+1<j&&s.charAt(k)==s.charAt(j)){
    //                     k++;
    //                     j--;
    //                     t+=2;
    //                 }
    //                 if(k+1==j&&s.charAt(k)==s.charAt(j)||k==j){
    //                     int tt;
    //                     tt=k+1==j?Math.max(sum,t+2):Math.max(sum,t+1);
    //                     if(tt>sum){
    //                         sum=tt;
    //                         ans=s.substring(i,sum+i);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return sum==0?s.substring(0,1):ans;
    // }
    private String s;
    private Boolean[][] dp;
    String ans="";
    public String longestPalindrome(String s) {
        this.s=s;
        int m=s.length();
        // this.dp=new Boolean[m][m];
        // dfs(0,m-1);
        // return ans;
      //正向填表
        boolean[][] dp=new boolean[m][m];
        for(int i=0;i<m;i++){
            dp[i][i]=true;
        }
        for(int j=m-1;j>0;j--){
            dp[j][j-1]=true;
        }
        for(int i=m-2;i>=0;i--){
            for(int j=i+1;j<m;j++){
                if(s.charAt(i)==s.charAt(j)&&dp[i+1][j-1]){
                    dp[i][j]=true;
                    if(j-i+1>ans.length()){
                        ans=s.substring(i,j+1);
                    }
                }
            }
        }
        if(ans.length()<1&&m>0){
            ans=s.substring(0,1);
        }
        return ans;
        
    }
  //bottom up填表
    private boolean dfs(int start,int end){
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        if(start>=end){
            if(ans.length()<1){
                ans=s.substring(start,end+1);
            }
            return true;
        }
        boolean res=false;
        if(s.charAt(start)==s.charAt(end)&&dfs(start+1,end-1)){
            if(end-start+1>ans.length()){
                ans=s.substring(start,end+1);
            }
            res=true;
        }else{
            dfs(start+1,end);
            dfs(start,end-1);
        }
        return dp[start][end]=res;
    }



}
