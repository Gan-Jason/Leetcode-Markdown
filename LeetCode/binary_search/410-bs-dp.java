//这题找到二分的单调性是关键，取分割数组后，子数组的sum中最大值，是所有切分的方案中最小的那个，因此子数组的sum有一个范围，即是[max(nums[i]),sum(nums[i])]，单个最大，到整个数组和
//二分的判断条件是，如果当前的mid，即是给定一个和，然后去切分数组，如果满足这个和切分出来的数组数量<=m,则mid给大了，right=mid，这里可能存在的答案就是mid所以要取到mid
//反之，mid给小了，这时候却分出来的数组数量必然>m,所以mid必然不是答案，mid=left+1，最后会得到一个答案
//给定一个和，如何去切分数组从而得到子数组的最大sum<=这个和，也是关键之处：
//首先累加nums[i]并记为sum，当sum>mid时，说明当前切分的子数组已经满足条件了，可以把该子数组计数并继续切分。切记的是，如果没有符合条件的切分时，那么至少不切分就是一个方案，因此计数器初始值为1

class Solution {
    public int splitArray(int[] nums, int m) {
        int left=0,right=0,mid;
        for(int i=0;i<nums.length;i++){
            right+=nums[i];
            left=Math.max(left,nums[i]);
        }
        while(left<right){
            mid=left+(right-left)/2;
            if(check(nums,mid,m)){    //如果符合m个以内，则这个mid可能是答案（即mid恰好是m个时），如果是小于m的话，说明mid给大了
                right=mid;
            }else{      //否则就是mid给小了，导致比m大，此时左区间肯定没有答案
                left=mid+1;
            }
        }
        return left;
    }
    private boolean check(int[] nums,int mid,int m){    //判断给定的mid，切分后是否数量<=m
        int arrNum=1,sum=0;   //计数器初始值为1，因为可以不切分
        for(int i=0;i<nums.length;i++){
            if(nums[i]+sum>mid){  //当sum要超过mid时，此时的数组就是符合条件的，切一刀。
                arrNum++;
                sum=nums[i];    //当前元素为下一个数组的开头
            }else{
                sum+=nums[i];   //不符合条件则继续要他
            }
        }
        return arrNum<=m;     //是否符合m个以内
    }
}
