'''Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.'''



class Solution(object):
    def majorityElement(self, nums: List[int]) -> int:                      #找出列表中出现次数最多的那个元素
        result={}                                                           #用字典存储列表中的元素和次数对，
        for num in nums:
            try:                              
                result[num]+=1                                               #计算元素在列表中出现的次数
            except:
                result[num]=1
        return sorted(result.items(),key=lambda item:item[1],reverse=1)[0][0]
