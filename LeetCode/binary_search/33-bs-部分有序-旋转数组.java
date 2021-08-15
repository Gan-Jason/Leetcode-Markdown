//旋转数组的特点是进行二分之后，比有一个是有序的数组，另外一个可能有序；记住这一特点即可
//首先判断左右两边哪个有序，对有序的部分进行判断，如果target在该区间中，则通过二分处理缩小范围；如果不在该区间，则只留下另一区间即可
//继续遍历剩下的部分
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null){
            return -2;
        }
        int len=nums.length;
        if(len==0){
            return -1;
        }
        int low=0,high=len-1;
        while(low<high){
            int mid=low+((high-low)>>1);
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<=nums[mid]){   //如果左边是有序的部分
                if(target>=nums[low]&&target<=nums[mid]){   //判断target是否存在该区间
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(target>=nums[mid]&&target<=nums[high]){  //右边区间是有序的数组
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return nums[low]==target?low:-1;
    }

}






