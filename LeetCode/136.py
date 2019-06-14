# Given a non-empty array of integers, every element appears twice except for one. Find that single one.
# Note:Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

class Solution:
    def singleNumber(self, nums: List[int]) -> int:                 # 找出列表中没有重复的数字，要求时间复杂度是O(n),不用多余空间
        return 2*sum(set(nums))-sum(nums)                           # 这是一个数学思想，2*（a+b+c)-(a+a+b+b+c)=c,从而得到不重复的元素
