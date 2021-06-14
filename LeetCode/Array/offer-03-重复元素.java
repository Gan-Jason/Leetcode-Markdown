//这题可以用元素计数法，时间花销为o(n),空间花销为o(n)
//也可以用空间为o(1)的 交换：遍历原数组，当当前的下标为i的元素不等于i时，把它换到自己的位子上，比如当前i=0,但是nums[0]=2,就把2换到nums[2]上，换之前先判断nums[2]是否已经重复了；
//继续判断当前位置，直到nums[i]=i,就开始遍历下一个位置
//这样每个元素的交换最多两次，即2n，所以时间也是O(n)


class Solution {
    public int findRepeatNumber(int[] nums) {
        int len=nums.length;
        // int[] count=new int[len];
        int ans=-1;
      //空间换时间
        // for(int i=0;i<len;i++){
        //     if(++count[nums[i]]>1){
        //         ans=nums[i];
        //         break;
        //     }
        // }
        // return ans;
        //时间换空间
        found:
            for(int i=0;i<len;i++){
                second:
                    while(nums[i]!=i){
                        if(nums[nums[i]]==nums[i]){
                            ans=nums[i];
                            break second;
                        }
                        int t=nums[i];
                        nums[i]=nums[t];
                        nums[t]=t;
                    }
                if(ans!=-1){
                    break found;
                }
            }
        return ans;
    }
}
