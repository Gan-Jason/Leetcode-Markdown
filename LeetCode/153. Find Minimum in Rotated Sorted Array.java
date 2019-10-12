/*
 *Share
 *Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 *(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 *Find the minimum element.
 *
 *You may assume no duplicate exists in the array.
 *
 *
 *
 *
 *
 *
 *
 */
 
 
 class Solution {
    //找到有序递增数组反转的位置，我这个是一次遍历，也就是O(n)如果当前位比前一位小，则当前位是结果
    public int findMin(int[] nums) {
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1])
                ans=nums[i];
        }
        return ans;
    }
}
