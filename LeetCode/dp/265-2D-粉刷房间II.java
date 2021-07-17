//这题的bottom up挺容易想出来的，直接考虑当前状态的构建，因为没有太多的限制条件，只有一个相邻房间不能为同种颜色，只需要把当前选中的颜色传上去，让上一个房间做个判断就行。
//dp[i][j]表示第i个房间粉刷j颜色所需要最少的钱。base case就是房间小于0时，返回0

class Solution {
    Integer dp[][];
    int[][] costs;
    int k;
    public int minCostII(int[][] costs) {
        int n=costs.length;
        if(n==0){
            return 0;
        }
        k=costs[0].length;
        // this.costs=costs;
        // this.dp=new Integer[n+1][k+1];
        // return dfs(n,k);
      
      //正向dp，正向花了好久时间，
      //正向需要两个变量，一个保存当前房间花最少的钱，第二个保存次少的钱，因为当下个房间需要粉刷的颜料跟当前花最少钱的一样时，就要用次少的钱对应的颜料，否则下个房间就不能粉刷这个颜色了
        int[][] dp=new int[n][k]; //dp[i][j]表示粉刷到第i房间时，要粉刷j颜料所需耗费的总金额。
        int preMin=-1;
        int preMin2=-1;
        for(int i=0;i<n;i++){
            int curMin=0x7fffffff;
            int curMin2=0x7fffffff;
            int curMinPos=-1;
            int curMinPos2=-1;
            for(int j=0;j<k;j++){
                if(i==0){   //初始化边界条件
                    dp[i][j]=costs[i][j];
                }else{
                    dp[i][j]=(j==preMin?dp[i-1][preMin2]:dp[i-1][preMin])+costs[i][j];    //判断当前选的颜色是否和上个房间选的一致，如果是一样的，之前花的钱就算次少的。
                }
                if(dp[i][j]<curMin){    //遍历出来比当前最少还要少，则最少和次少都要更新
                    curMin2=curMin;
                    curMinPos2=curMinPos;
                    curMin=dp[i][j];
                    curMinPos=j;
                }else if(dp[i][j]<curMin2){   //只比次少要少，就只更新次少
                    curMin2=dp[i][j];
                    curMinPos2=j;
                }
                
            }
            preMin=curMinPos;   //当前的房间算完了，当前房间的变为pre
            preMin2=curMinPos2;
        }
        return dp[n-1][preMin];   //最后一个房间粉刷完后所需所有的钱，就是dp[n-1][curPos]，这里的pre已经更新为cur了
    }
    //bottom up
    private int dfs(int n,int j){
        if(dp[n][j]!=null){
            return dp[n][j];
        }
        if(n==0){
            return 0;
        }
        int res=0x7fffffff;
        for(int i=0;i<k;i++){   //因为这里做了一个循环，找出当前房间粉刷所有颜色的话，花最少钱的那种，其实也就是第n个房间吧所有颜料都粉刷一遍，选最便宜的
            if(i!=j){
                res=Math.min(res,dfs(n-1,i)+costs[n-1][i]); //第n房间选中i颜料后，上面的房间是有限制的，
            }
        }
        return dp[n][j]=res;
    }
}
