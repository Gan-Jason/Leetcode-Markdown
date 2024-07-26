/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent,

with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.
*/


// class Solution {
//     public void sortColors(int[] nums) {
           //这种是两段式方法，首先累计数组中0，1，2的出现次数，再重新遍历数组，分别根据各数字的出现次数、按次序重新给数组赋值0，1，2，
//         int sum0=0,sum1=0,sum2=0;
//         for(int i=0;i<nums.length;i++){
//             if(nums[i]==0)
//                 sum0++;
//             else if(nums[i]==1)
//                 sum1++;
//             else 
//                 sum2++;
        
//         }
//         for(int i=0;i<nums.length;i++){
//             if(i<sum0)
                   //赋值0
//                 nums[i]=0;
//             else if(i>=sum0&&i<sum1+sum0)  //赋值1
//                 nums[i]=1;
//             else
//                 nums[i]=2;                 //赋值2
//         }
//     }
// }


class Solution{
    public void sortColors(int[] nums) {
        //非递归的快排
        if(nums.length<=1)
            return;
        int[] stack = new int[nums.length]; //初始化栈，用来存放每次排序的数组片段的始末端
        int top=-1,h,l;
        //开始的始末端是整个数组长度
        stack[++top]=0;
        stack[++top]=nums.length-1;
        //栈非空时进行遍历栈
        while(top>=0){
            h=stack[top--];
            l=stack[top--];
            int p=partition(nums,l,h);  //排序第一次
            //轴心的左边除了始端还有元素的时候，把左边数组始末端放进栈中，待会排序
            if(p-1>l){
                stack[++top]=l;
                stack[++top]=p-1;
            }
            //同理，把轴心的右边压进栈中
            if(p+1<h){
                stack[++top]=p+1;
                stack[++top]=h;
            }

        }
    }
    private int partition(int[]nums,int l,int h){
    //以最后一位为轴心，把最后一位放到合适的位置，也就是轴心的左边都比轴心小，轴心的右边都比轴心大，最后返回轴心的位置
        int x=nums[h];
        int i=l,j=h;
        while(i<j){
            while(i<j&&nums[i]<=x)i++;
            if(i<j){
                nums[j]=nums[i];
                j--;
            }
            while(i<j&&nums[j]>=x)j--;
            if(i<j){
                nums[i]=nums[j];
                i++;
            }
        }
        nums[i]=x;
        return i;
    }
}
