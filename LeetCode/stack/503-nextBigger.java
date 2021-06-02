//1.暴力解，循环遍历两次元素组，采用环形遍历
//2. 栈，这题由于有环，所以用栈的话也要环形遍历原数组，因此遍历长度为2len-1，即到自己左边的元素即可，这个方法我遇到的问题是，如何做到遍历指针的迭代和控制范围使得不会越界以及不超过本身的下标
//，第二个问题是前面遍历好的元素如何避免重新遍历一次，还有就是这题是把下标压入栈中，因为有环，如果栈放的是元素，则ans数组不知道当前栈中处理的是第几个了
//其实这两个问题差不多是一个，只要遍历两次原数组即可，遍历好的元素重新遍历一次也不会出错，只是把原来的答案再重写一次，如果是只在一个循环里处理的话，就不要去做避免重复的操作了，会比较麻烦
//如果是用两个循环做，即分两次遍历原数组，这样发现速度会快一点，思路也会清晰一点
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len=nums.length;
        if(len==0){
            return nums;
        }
        //1 暴力解
        // for(int i=0;i<len;i++){
        //     int flag=-1;
        //     for(int j=(i+1)%len;j!=i&&j<len;j=(j+1)%len){
        //         if(nums[j]>nums[i]){                                                                
        //             flag=nums[j];
        //             break;                  
        //         }               
        //     }
        //     ans[i]=flag;                    
        // }
        // return ans;
        //2. 栈，第一次循环解决部分，剩下在栈中的都是从下到上，单调不减的
        Deque<Integer> stack=new ArrayDeque<>();                                                                       
        int[] ans=new int[len];
        for(int i=0;i<len;i++){
            while(!stack.isEmpty()&&nums[stack.peek()]<nums[i]){
                ans[stack.pop()]=nums[i];
            }
            stack.push(i);
        }
        //第二次遍历原数组，处理栈中剩下的元素，
        while(!stack.isEmpty()){
            int tail=stack.pop();
            int flag=-1;
            for(int i=0;i<tail;i++){
                if(nums[i]>nums[tail]){
                    flag=nums[i];
                    break;
                }
            }
            ans[tail]=flag;
        }
        return ans;
    }
}
