/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
 
 
 class Solution {
    //查找数组中没有重复出现的数，每个数组只有一个数只出现了一次，其他的均出现三次。
    //空间复杂度要求是O(1)
    //这个题目思路就是先排序，然后i以3个单位为步长，如果i不是队尾且nums[i]!=nums[i+1]则是独狼，如果前面都没有独狼，则最后一个必是独狼
    public int singleNumber(int[] nums) {
        if(nums.length==1)
            return nums[0];
        Arrays.sort(nums);
        int i=0;
        for(i=0;i<nums.length;i+=3){
            if(i<nums.length-1&&nums[i]!=nums[i+1])
                return nums[i];

        }
        return nums[i-3];
    }
}
