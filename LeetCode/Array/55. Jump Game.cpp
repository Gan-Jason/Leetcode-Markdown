class Solution {
public:
    bool canJump(vector<int>& nums) {
    //判断是否为可以从左跳到最右的数组
        //lastPos是更新的目标位置
        int lastPos=nums.size()-1;
        从右往左循环
        for(int i=nums.size()-1;i>=0;i--){
            //如果当前位置索引加当前位置的步数大于目标位置的话，就更新目标位置
            if(i+nums[i]>=lastPos){
                lastPos=i;
            }
        }
        //最后看是否走到最左边位置，也即开头，若走不到就是一开始就无法往右走
        return lastPos==0?true:false;
    }
};
