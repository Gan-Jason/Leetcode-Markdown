//这题主要找规律，下一个字典排序的数是怎么产生的，假设一个数已经是各个数位上都排的最大了，这个数的数字一定是单调递减的，如果一个数还有上升的空间，就从后往前找最短的单调递减序列
//只有个位数的话，就视为单调递减的。然后定位到单调递减序列的前一位i，第二次遍历是从右边找出比i大的第一个数j（在单调递减序列中，这个数就是该序列比i大的最小值），交换i和j
//i的右边必然是一个最大数，即单调递减的序列，把该序列反转一下就可以保证是最小值了，即下一字典排序数。
//证明上述i的右边是最大数：因为i的右边都大于i且单调递减，j>i,且j>i>j-1,所以把j和i交换后，右边的序列仍然是最大值，序列反转即变为最小值

class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1){
            return;
        }
        int i=nums.length-1,j=i;
        while(i>=1&&nums[i]<=nums[i-1]){    //找到最大序列的左邻居
            i--;
        }
        if(i>0){
            i--;
        while(j>0&&nums[j]<=nums[i]){     //找到右边比左邻居大的最小值
            j--;
        }
            int t=nums[i];            //交换两者
            nums[i++]=nums[j];
            nums[j]=t;
            j=nums.length-1;
            while(i<j){   //反转最大序列
                t=nums[i];
                nums[i++]=nums[j];
                nums[j--]=t;
            }
            return;
        }
        Arrays.sort(nums);
    }
}
