/*
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 */
 
 class Solution {
    //找出数组中的极大值点，一次遍历，当前元素与前后做差值，如果皆大于0则为极大值点；最后一个元素因为右极限是-∞，所以只需要与左边比较大小即可
    public int findPeakElement(int[] nums) {
        int ans=0;
        for(int i=1;i<nums.length;i++){
            if(i<nums.length-1){
                if(nums[i]-nums[i-1]>0&&nums[i]-nums[i+1]>0){
                    ans=i;
                    break;
                }
                    
            }
            else{
                if(nums[i]-nums[i-1]>0){
                    ans=i;
                    break;
                }
                    
            }
        }
        return ans;
    }
}
