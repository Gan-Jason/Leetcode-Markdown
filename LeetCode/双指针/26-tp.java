//同向双指针法，

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1){
            return nums.length;
        }
        int i=0,j=0;
        while(j<nums.length){
            if(i==0||nums[j]!=nums[i-1]){     //模版
                nums[i++]=nums[j];
            }
            j++;
        }
        return i;
    }
}
