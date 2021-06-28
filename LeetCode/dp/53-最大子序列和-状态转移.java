//这题用模版半天没做出来，
//用状态转移方程倒是挺容易理解的：dp[i]=Math.max(nums[i],dp[i-1])；dp[i]记录以i为结尾的序列最大子序列和，因此dp[i]的计算，要么选nums[i]，要么不选，决定了再更新状态
//最后dp数组中最大值即为答案

class Solution {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        if(len==1){
            return nums[0];
        }
        int ans=nums[0];
        for(int i=1;i<len;i++){
            if(nums[i-1]>=0){
                nums[i]+=nums[i-1];
            }
            ans=Math.max(ans,nums[i]);
        }
        return ans;
    }
}
