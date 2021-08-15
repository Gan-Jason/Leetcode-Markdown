//这题用二分的话，需要明确的是，旋转后只有两个情况，设最小元素为p，则旋转后的数组为p之前的较大递增数组，p开始的较小递增数组
//二分的时候判断mid存在于哪个数组中，i表示二分的头，j表示二分的尾，则i代表较大，j代表较小，如果mid比j小，则位于较小数组中，如果mid比j大，则位于较大数组中
//特殊情况，如果i，j，mid都相等，则无法判断两个数组情况，需要o(n)遍历了
class Solution {
    public int minArray(int[] numbers) {
        int i=0,j=numbers.length-1;
        while(i<j){
            int mid=i+((j-i)>>1);
            if(numbers[i]==numbers[j]&&numbers[mid]==numbers[i]){   //特判
                int ans=0x7fffffff;
                for(int p=0;p<numbers.length;p++){
                    ans=Math.min(ans,numbers[p]);
                }
                return ans;
            }
            if(numbers[mid]<=numbers[j]){
                j=mid;
            }else{
                i=mid+1;
            }
        }
        return numbers[i];
    }
}
