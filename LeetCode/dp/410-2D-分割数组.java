//这题可以用二分查找，单调区间是[max(nums[i]),sum(nums[]))，在这区间内找子数组和，再判断：按照子数组和不能超过这个数来拆分，拆分出来的数组数量是否满足<=m，
//一维数组加一个状态，也可以用2D的动态规划，dp[n][k]表示，数组长度为n，拆分次数为k，最小的最大数组和是多少
//找base case，当k==1时，返回整个数组和；当n<k时，拆分次数比数组长度大，返回-1表示没有答案
//再找当前问题的选择：可以在数组中随意切割一刀，得到两个数组，一个是当前选的数组，剩下的就是子问题，则问子问题要答案。再构建当前问题答案
//需要注意的点，如果当前切的这一刀导致子问题没有答案：返回-1，则丢弃这一刀，继续遍历切法找最优解。

class Solution{
    private int[] nums;
    private int n;
    private Integer[][] dp;
    private int[] prefix;
    public int splitArray(int[] nums, int m) {
        this.nums=nums;
        n=nums.length;
        prefix=new int[n+1];
        int i=0;
        while((prefix[i+1]=prefix[i]+nums[i])>=0&&++i<n);
        this.dp=new Integer[n+1][m+1];
        return dfs(n,m);
    }
    private int dfs(int n,int k){
        if(k>n){  
            return -1;
        }
        if(n<=1||k==1){
            return prefix[n];
        }
        if(dp[n][k]!=null){
            return dp[n][k];
        }
        int res=2147483647;   //当前问题的答案
        for(int i=n-1;i>=1;i--){  //遍历所有切法，找最优解
            int right=prefix[n]-prefix[i];
            int left=dfs(i,k-1);
            if(left==-1){
                continue;
            }
            res=Math.min(Math.max(right,left),res);
        }
        return dp[n][k]=res==2147483647?-1:res;
    }
}
