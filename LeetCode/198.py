'''You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house,
determine the maximum amount of money you can rob tonight without alerting the police.'''

class Solution:                                                           
    def rob(self, nums: List[int]) -> int:                                            \#用动态规划实现偷家的最佳方案
        if not len(nums):                                                             
            return 0
        dp=[0]*(len(nums)+1)                                                          \#初始化一个dp数组，长度为原数组的长度+1，
        dp[1]=nums[0]                                                                 \#dp数组一般首位都置零，为的是后面会用到前面的结果，而dp[0]不存结果
        for i in range(1,len(nums)):                                                  \#dp[1]表示走到第一家为止，最佳的偷盗方案就是只能偷第一家,从1开始遍历     
            current=nums[i]                                                           \#dp[i+1]为该位置最佳方案，如果用dp第i个方案的话就不能继续偷当前家的钱，如果用第i-1个方案的话可以偷当前房子，再加第i-1个方案的钱
            dp[i+1]=max(dp[i],dp[i-1]+current)
        return dp[len(nums)]                                                          \#则dp数组最后一个就是最优的方案
        \#     def Rob(self,nums,i):                                                   \#这种是递归的方法，从最后一家开始偷，也就是尾递归，
        \#         if i<0:   
        \#             return 0
        \#         return max(self.Rob(nums,i-2)+nums[i],self.Rob(nums,i-1))           \#如果当前家i偷的话，可以接着偷i-2家，否则只能偷i-1家，比较两者的利润，取大者，往回递归
