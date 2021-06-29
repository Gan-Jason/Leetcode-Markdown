//dfs，dp解题，
//注意的点是，每次选只能选平方数i，然后问dfs(n-i)要答案，
//错误点：1.没有选平方数，2. 控制每次遍历平方数的循环条件出错 3. 没有更新dp[n]，当n是平方数时，这样可以更省时，每次先判断dp是否已经计算过，因为你的base case check中比较耗时

class Solution {
    private int[] dp;
    private int ans;
    public int numSquares(int n) {
        this.dp=new int[n+1];
        ans=10001;
        return dfs(n);
    }
    // public int numSquares(int n) {
    //     int[] f = new int[n + 1];
    //     for (int i = 1; i <= n; i++) {
    //         int minn = Integer.MAX_VALUE;
    //         for (int j = 1; j * j <= i; j++) {
    //             minn = Math.min(minn, f[i - j * j]);
    //         }
    //         f[i] = minn + 1;
    //     }
    //     return f[n];
    // }


    private int dfs(int n){
        if(dp[n]!=0){
            return dp[n];
        }
        if(n==1||Math.sqrt(n)-(int)Math.sqrt(n)==0){    //这里也耗时
            return dp[n]=1;
        }
        int res=10001;
        int i=1;
        int squre=1;
        while(squre<n){
            res=Math.min(res,1+dfs(n-squre));
            i++;
            squre=i*i;
        }
        return dp[n]=res;
    }

    private boolean isSqrt(int n){
        int left=1,right=n;
        while(left<=right){
            int mid=left+(right-left)/2;
            int res=mid*mid;
            if(res==n){
                return true;
            }else if(res>n){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }

}
