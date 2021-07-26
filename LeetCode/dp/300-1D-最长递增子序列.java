// 这题是可以用dp的，但是bottom up的没想出来
//正向填表的话，设dp[i]为以nums[i]为结尾的最长子序列长度(注意一定是以nums[i]结尾)，则dp[i]=max（dp(0,i-1)+1）/1
//这里的意思是：只有当dp[i]能加入之前的任何一个以j为结尾的子序列的时候，才能把前面的子序列的状态转移到当前位置来，否则就只能算他自己一个
//即每次计算dp[i]，要遍历之前的最长子序列长度，并和nums[j]比较，是否比其大，只有比他大才能加入它，
class Solution {
    int[] nums;
    public int lengthOfLIS(int[] nums) {
        this.nums=nums;
        
        int len=nums.length;
        if(len==0)return 0;
        int[] dp=new int[len];
        dp[0]=1;
        int ans=1;
        for(int i=1;i<len;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                    ans=Math.max(ans,dp[i]);
                }
            }
        }
        return ans;
    }


}
