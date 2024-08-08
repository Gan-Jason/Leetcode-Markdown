//本题用二分查找，出错的地方是找到第一个target的位置后，就用了线性查找的方式去找左边第一个，和右边第一个，这样最坏的复杂度也是o(n)，当全是target的时候
//因此first和last都要用二分查找，
//先二分到第一个target，在从mid的左侧去找first，因为first肯定不在右边
//再从first的右边去找last

class Solution {
    int first;
    public int[] searchRange(int[] nums, int target) {
        // int[] ans=new int[2];
        // ans[0]=-1;
        // ans[1]=-1;
        // if(nums.length==0){
        //     return ans;
        // }
        // first=-1;
        // binarySearch(nums,0,nums.length-1,target);//二分
        // if(first==-1)return ans;
        // int i=first,j=first;
        // while(i>0&&nums[i-1]==target){     //这里用了线性查找
        //     i--;
        // }
        // while(j<nums.length-1&&nums[j+1]==target){
        //     j++;
        // }
        // ans[0]=i;
        // ans[1]=j;
        int first=findFirst(nums,target);
        if(first==-1){
            return new int[]{-1,-1};
        }
        int last=findLast(nums,target);

        return new int[]{first,last};

    }
    private void binarySearch(int[] nums,int left,int right,int target){
        if(left>right)
            return;
        int mid=(left+right)/2;
        if(left==right&&nums[left]==target){
            first=left;
            return;
        }
        if(nums[mid]==target){
            first=mid;
            return;
        }
        if(nums[mid]<target)
            binarySearch(nums,mid+1,right,target);
        else
            binarySearch(nums,left,mid-1,target);
    }

    private int findFirst(int[] nums,int target){   //找到first
        if(nums.length==0){
            return -1;
        }
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=(left+right)>>1;
            if(nums[mid]<target){   
                left=mid+1;
            }else if(nums[mid]==target){
                right=mid;
            }else{
                right=mid-1;
            }
        }
        if(nums[left]!=target){
            return -1;
        }
        return left;
    }

    private int findLast(int[] nums,int target){  //找last
        if(nums.length==0){
            return -1;
        }
        int left=0,right=nums.length-1;
        while(left<right){
            int mid=(left+right+1)>>1;      //这里要注意，如果是往左侧找的last的话，二分时要取右半区，否则会出现死循环，
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]==target){    //如果mid是取左半区，会导致left一直等于mid，left，mid，right就不动了
                left=mid;
            }else{
                right=mid-1;
            }
        }
        return left;
    }




}
