/*
*
*
*
*
*Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s.
*If there isn't one, return 0 instead.
*/

class Solution {
    //找出数组中元素之和大于等于s的最短子数组的长度
    //我用的是双指针法，快慢指针，快指针先遍历，一边遍历一遍计算子数组元素之和，找到符合条件的子数组后实时更新最短长度的值
    //当前元素之和减去慢指针的元素，慢指针再往前移动一步
    public int minSubArrayLen(int s, int[] nums) {
        int sum=0,slow=0,minLen=Integer.MAX_VALUE;
        for(int fast=0;fast<nums.length;fast++){
            //累加子数组元素之和
            sum+=nums[fast];
            //如果子数组元素之和不小于s，则更新数据
            while(sum>=s){
                //更新最短长度
                minLen=Math.min(minLen,fast-slow+1);
                //更新sum、慢指针往前移一步
                sum-=nums[slow++];
            }
        }
        //最后判断一下最短长度是否更新过，如果没有，说明数组中不存在符合条件的子数组
        return Math.min(minLen,Integer.MAX_VALUE)==Integer.MAX_VALUE?0:minLen;
    }
}
