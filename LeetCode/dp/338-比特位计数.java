//可以用位移计算，时间复杂度为nlog(n)
//也可以一次遍历，记录当前n的比特位，可以发现规律，n的比特位等于，dp[n-high]+1,high是当前n的位长度的2的k次幂，比如2，4，8，16...这个high计算方式为:n&(n-1)==0时。hihg=n


class Solution {
    public int[] countBits(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        int high=0;
        for(int i=1;i<=n;i++){
            if((i&i-1)==0){
                high=i;
            }
            dp[i]=dp[i-high]+1;
        }
        return dp;
    }
}

class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++){
            int t=i;
            int res=0;
            while(t>0){
                if((t&1)==1){   //向右位移
                    res++;
                }
                t>>=1;
            }
            ans[i]=res;
        }
        return ans;
    }
}
