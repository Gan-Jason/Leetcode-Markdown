//这题需要注意细节：
//base case是，k==0｜｜n==0时，返回0，k<0时返回-1，表示无答案
//构建当前答案时。不是所有的子问题答案都能要的，需要剔除不符合条件的，比如返回值为-1，或者返回值比之前计算值还要大，就不能要了，否则会导致结果变成选的最右边符合条件的了，而不是最优解了
//最后注意的是，如果遍历完计算完后，没有合适的答案，则还要判断一下

class Solution {

    private int[] coins;
    private Integer[][] dp;
    public int coinChange(int[] coins, int amount) {
        this.coins=coins;
        int n=coins.length;
        this.dp=new Integer[n+1][amount+1];
        return dfs(n,amount);
    }

    private int dfs(int n,int k){
        if(k==0||n==0){ //表示查找完毕
            return 0;
        }
        if(k<0){    //这里也是重点，为什么要返回-1，表示结果不存在
            return -1;
        }
        if(dp[n][k]!=null){
            return dp[n][k];
        }
        int res=2147483647;
        for(int i=0;i<n;i++){
            int ans;
            if((ans=dfs(n,k-coins[i]))>=0&&ans<res){    //这里要很注意，。如果-1也计算的话就乱了；保持最优解，就是子问题答案也是最优解
                res=ans+1;
            }
            
        }
        return dp[n][k]=res==2147483647?-1:res;     //如果没有最优解，返回-1

    }
}
