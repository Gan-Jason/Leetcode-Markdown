'''Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.'''


class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:						#求有序数组中两个和为target的元素，两元素不能重合且必有一解
        # i = 0																										            #所以这道题就比较简单了，可以类似两木板构造容积最大的木桶原理一样，
				# j = len(numbers)-1																						      #用双指针法i，j，分别从表头和表尾开始遍历，两元素和比target大了则j--,fo否则i++
        # result = []
        # while i<j:
        #     if numbers[i]+numbers[j]<target:
        #         i += 1
        #     elif numbers[i]+numbers[j]>target:
        #         j -= 1 
        #     else:
        #         result.append(i+1)
        #         result.append(j+1)
        #         break
        # return result
        dic={}																														    #第二种是枚举数组中键值对，判断target-num是否在构造的字典中，该字典是存放数组键值对的
        for i,num in enumerate(numbers):																		  #先存放键值对于字典中再遍历字典，为的是以防出现两个等值元素时，用in逻辑判断无法取到第二个元素的情况
            if target-num in dic:
                return [dic[target-num],i+1]
            dic[num]=i+1
