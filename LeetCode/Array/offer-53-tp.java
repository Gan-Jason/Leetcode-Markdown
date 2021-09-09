//tp难点在于边界条件，即low，high取值，如何移动指针等
//这题有一个误区，找到了第一个target的位置就进行左右计数了，那这样最坏的情况也是o(n)
//应该用二分找到左右边界，然后R-L+1就是长度。
//边界问题搞了好久，需要熟练

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==1){
            return nums[0]==target?1:0;
        }
        if(nums.length==0){
            return 0;
        }
        int l=getPos(nums,target,true);
        System.out.print(l);
        if(l==-1){
            return 0;
        }
        int r=getPos(nums,target,false);
        
        return r-l+1;
    }
    int getPos(int[] nums,int target,boolean flag){
        int i=0,j=nums.length-1;
        int pos=0;
        if(flag){   //求左下标
            while(i<j){   //如果这里是i<j那么最后一定是i==j结束，那还要判断下i==j情况，
                int mid=i+((j-i)>>1);
                if(nums[mid]>=target){    //注意这里的取值会不会影响指针移动
                    j=mid;
                    pos=mid;
                }else{
                    i=mid+1;
                }
            }
        }else{      //求右下标
            while(i<j){
                int mid=i+((j-i+1)>>1);   
                if(nums[mid]<=target){    //由于这里是往右移，因此要mid取右半区，就是，要注意指针移动会不会造成死循环，比如看最后的相邻位置的mid取值，low，high取值
                    i=mid;
                    pos=mid;
                }else{
                    j=mid-1;
                }
            }
        }
        if(nums[j]==target){
            pos=j;
        }
        return nums[pos]==target?pos:-1;
    }

    

}
