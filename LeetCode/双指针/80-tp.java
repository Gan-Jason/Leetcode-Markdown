//双指针，保留原数组的相对位置，就是快慢指针，即同向
//初始化i和j，本题是不能超过两个重复，因此选择j元素的条件应该是，a[j]!=a[i-2]，
//只有选择了j上的元素，i才会移动

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int i=2,j=2;
        while(j<nums.length){
            if(nums[j]!=nums[i-2]){
                nums[i++]=nums[j];
            }
            j++;
        }
        return i;
    }
}
