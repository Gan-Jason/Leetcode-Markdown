//设变量，dp[m][k]表示，m天交易日，可以做k笔交易，得到最大的利润
//base case：当k==0||m<=1时，利润为零
//当前问题状态：当前天，可以买，也可以不买；买的话要什么时候卖才是利润最高，计算该利润，需要做遍历找出，然后把剩余的交易日通过子问题计算答案。
//如果不买，则直接计算子问题答案。

class Solution {
    private int[] prices;
    private Integer[][] dp;
    public int maxProfit(int k, int[] prices) {
        this.prices=prices;
        int n=prices.length;
        // this.dp=new Integer[m+1][k+1];
        // return dfs(0,n,k);
        int[][] dp=new int[n+1][k+1];
        for(int i=1;i<=n;i++){      //正向填表
            for(int j=1;j<=k;j++){
              //当前天不交易的话，就是问子问题要答案
                int notBuy=dp[i-1][j];
                int res=0;
                for(int m=1;m<i;m++){
                    //正向填表的话，需要理解这个i，j，m，表示的是当前状态是卖而不是买，因为是正向的，因此要看当前位置的话，只能是卖
                    //而当前卖掉的话，就是当前的价格减去在第m天买入的价格，因此是price[i-1]-price[m-1]，(dp数组右移了一位)。子问题的答案就是dp[m][j-1]
                    int buy=prices[i-1]-prices[m-1]+dp[m][j-1];  
                    //
                    res=Math.max(Math.max(buy,notBuy),res);
                }
                dp[i][j]=res;
            }
        }
        return dp[n][k];
    }

    private int dfs(int start,int m,int k){   //逆向填表
        if(k==0||m<=1){
            return 0;
        }
        if(dp[m][k]!=null){
            return dp[m][k];
        }
        int res=0;
        int notBuy=dfs(start+1,m-1,k);    //问子问题要答案
        for(int i=1;i<m;i++){   //在第i天后卖出
            int buy=prices[start+i]-prices[start]+dfs(start+i,m-i,k-1);   //此时当前状态的利润是多少，再问子问题要答案
            res=Math.max(Math.max(buy,notBuy),res); //选最大值
        }
        return dp[m][k]=res;
    }
}
