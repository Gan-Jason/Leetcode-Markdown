'''Given an array, rotate the array to the right by k steps, where k is non-negative'''



class Solution:                                                         #循环移动数组，第一想到就是暴力解，数组中每个元素都和第一个元素交换位置后整个数组就向右原地移动了一步，如果要移动k步的话要重复这个过程k次，然而这个方法超时了
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.           #还有两种方法，第一种是翻转数组，首先整个数组翻转；然后再翻转前k个；最后翻转剩余的。别管他什么原理，反正最后结果是对的
        """
        k%=len(nums)                                                    #k要对数组长求余，得到比数组长小的但是相同结果的步数，这和循环队列是一个道理
        nums.reverse()
        nums[0:k]=nums[0:k][::-1]
        nums[k:len(nums)]=nums[k:len(nums)][::-1]
        #         self.reverse(nums,0,len(nums)-1)                      #第二种是自己写的reverse...
        #         self.reverse(nums,0,k-1)
        #         self.reverse(nums,k,len(nums)-1)

        #     def reverse(self,nums,head,tail):
        #         while head<tail:
        #             nums[head],nums[tail]=nums[tail],nums[head]
        #             head+=1
        #             tail-=1

 //从第一个数开始往后交换，每个数要换到下一个位置next，next=(cur+k)%nums.length，当换了一圈时，会有一部分没有被换到，因此需要一个外循环，从0开始迭代，
//循环结束条件是只要交换的数量为nums.length即可
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length<=1){
            return;
        }
        int count=0;
        for(int i=0;i<nums.length&&count<nums.length;i++){
            int pre=nums[i],cur=i;
            do{
                int next=(cur+k)%nums.length;
                int t=nums[next];
                nums[next]=pre;
                pre=t;
                cur=next;
                count++;
            }while(cur!=i&&count<=nums.length);
        }
    }
}
