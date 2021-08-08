//这题一看就用了dfs+回溯去查找，但是超时了
//首先可以用dfs，注意要遍历每个位置作为dfs的入口，并且用path数组标记已走过的路线，当前位置都dfs结束后回溯时要擦除脚印，否则会导致后面的dfs没法走当前的路
//超时的原因是有重复子问题，设memo[i][j]表示(i,j)出发最长的递增子序列，那么如果能走到这个位置只需要加上这一段长度即可，不需要再重复走了

class Solution {
    private int[][] matrix;
    private int m;
    private int n;
    private Integer[][] memo;
    boolean[][] path;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null){
            return -1;
        }
        this.matrix=matrix;
        this.m=matrix.length;
        if(m==0){
            return 0;
        }
        this.n=matrix[0].length;
        this.memo=new Integer[m][n];
        this.path=new boolean[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,dfs(i,j,-1));
            }
        }
        return ans;
    }
    private int dfs(int i,int j,int pre){
        if(i<0||i>=m||j<0||j>=n||path[i][j]||matrix[i][j]<=pre){    //base case，无法走的路就返回长度0
            return 0; 
        }
        if(memo[i][j]!=null){   //已计算过
            return memo[i][j];
        }
        path[i][j]=true;
        pre=matrix[i][j];
        int res=0;
        res=Math.max(dfs(i+1,j,pre)+1,res);   //dfs，问子问题要答案，并更新当前的最优解
        res=Math.max(dfs(i,j+1,pre)+1,res);
        res=Math.max(dfs(i-1,j,pre)+1,res);
        res=Math.max(dfs(i,j-1,pre)+1,res);
        path[i][j]=false;   //回溯时擦出脚印
        return memo[i][j]=res;
    }
}


