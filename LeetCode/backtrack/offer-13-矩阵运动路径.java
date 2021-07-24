//这题带着分治思想的回溯，回溯的点是base case不满足的时候；
//我错的点是尝试用top down去计算所有的路径和，但这种方法只能找到最长的路径，不能累加所有
//类似这种要累加所有的路径题目，最好用bottom up，先计算当前状态的答案，再问子问题要答案

class Solution {
    boolean[][] path;
    int m;
    int n;
    public int movingCount(int m, int n, int k) {
        this.m=m;
        this.n=n;
        this.path=new boolean[m][n];    //标记走过的路径
        return dfs(0,0,k);
    }

    public int dfs(int i,int j,int k){
        if(i<0||i>=m||j<0||j>=n||path[i][j]==true){   //base case
            return 0;
        }
        int sum=0,p=i,q=j;
        while(p>0){
            sum+=p%10;
            p/=10;
        }
        while(q>0){
            sum+=q%10;
            q/=10;
        }
        if(sum>k){
            return 0;
        }
        path[i][j]=true;
        return 1+dfs(i+1,j,k)+dfs(i-1,j,k)+dfs(i,j+1,k)+dfs(i,j-1,k);
    }
}
