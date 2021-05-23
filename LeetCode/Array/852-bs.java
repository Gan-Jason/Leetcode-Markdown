//这题的单调增的序列就是index，因此对index进行二分
//如果arr[mid]满足条件则直接return，如果mid是左侧山体，则山顶在右区间，left=mid+1
//如果mid是右侧山体，则山顶在左区间，right=mid-1，由于这里要用到mid-1，因此mid要取上半区，不然会越界

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left=0,right=arr.length-1;
        while(left<right){
            int mid=left+(right-left+1)/2;    //注意mid取值
            if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1]){   //山顶直接返回，这里也可以不用判断，就是再走一遍循环的时间，代码有点冗余
                return mid;
            }else if(arr[mid]<arr[mid-1]){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
}
