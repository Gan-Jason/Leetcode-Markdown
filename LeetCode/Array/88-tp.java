//有序的合并，用双指针遍历两个数组，取出较小的数并存放到新队列中，这个方法需要额外的空间o(m+n)
//本题我的问题是，两个数组是长度不一的，因此遍历两个不同长度数组如何控制遍历指针，
//可以按照其中一个数组长度来遍历，剩下没遍历的就是长的，并且都是较大的数，放在队尾即可。
//另一种不需要额外空间的解法是，从后往前遍历，把大数放在第一个数组中的后半部分即可。

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
            if(n==0)return;
            int i=0,j=0,c=0;
            int[] h=new int[m+n];
            while(j<n){
                if(nums2[j]>=nums1[i]&&i<m){
                    h[c++]=nums1[i++];
                }else{
                    h[c++]=nums2[j++];
                }
            }
            while(i<m)h[c++]=nums1[i++];
            while(j<n)h[c++]=nums2[j++];
            for(i=0;i<m+n;i++){
                nums1[i]=h[i];
            }


    }
}
