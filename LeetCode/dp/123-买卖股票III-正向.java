//这题的dp属于正向，（bottom up严重超时了），
//正向：从中间状态考虑，某一天的状态有四种：1. 停留在第一次买入 2 第一次卖出 3 第二次买入 4 第二次买入，因此可以用四个变量表示这四个状态:buy1,sell1,buy2,sell2
//想要得到最大的利润，那就是sell2最大，因为这四个是相互依赖关系。
//要是sell2最大，buy1要最小，sell1要最大，buy2要最下。，buy1就是跟每天的价格比较，还要跟上一个的buy1比较取最小；其他三个也是
//最关键的一点就是要理解：其实是每天都做了这四个状态的计算，即假设每天都可以：第一次买，第一次卖，。。。就是说计算这四个值时，其实是分别的上一个比较的计算

class Solution {
    private int[] prices;
    private Integer[][] dp;

    public int maxProfit(int[] prices) {
        this.prices=prices;
        int n=prices.length;
        // this.dp=new Integer[n+1][3];
        // return dfs(0,n,2);
        int buy1=prices[0],sell1=0,buy2=prices[0],sell2=0;
        for(int i=0;i<n;i++){
            buy1=Math.min(buy1,prices[i]);    //选最小的
            sell1=Math.max(sell1,prices[i]-buy1); //选第一次买卖最大利润
            buy2=Math.min(buy2,prices[i]-sell1);
            sell2=Math.max(sell2,prices[i]-buy2);
        }
        return sell2;

    }
    //超时了
    private int dfs(int start,int n,int k){
        if(k==0||n<=1){
            return 0;
        }
        if(dp[n][k]!=null){
            return dp[n][k];
        }
        int res=dfs(start+1,n-1,k);
        for(int i=1;i<n;i++){
            res=Math.max(res,prices[start+i]-prices[start]+dfs(start+i,n-i,k-1));
        }
        return dp[n][k]=res;
    }
}
