//这题属于数组+k，但是答案要求是找所有可能的组合，所以dp似乎不太合适，因为状态不能是一个数组，
//尝试过用回溯，但是不能有重复的组合，去重是一件麻烦的事情，我用了set+自定义数据结构去去重，即用node表示一个组合，当两个组合中的数一样时，这两个node equals，在用set去重。但是超时了。。
//数组的话，最基础就是双指针法（每次应该快速想一下暴力解，从基础的递增，不要一上来就想着o(n)）。这题是三个数，因此需要先固定一个数，其实用暴力法枚举三个数也行，只要前两个不重复，第三个必不重复
//先排序，枚举第一个位置，并跳过重复元素，第二个和第三个在有序数组中就是相向的two pointers了，注意第二个也要去重，第三个必不重复

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        if(nums.length<3){
            return ans;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2&&nums[i]<=0;i++){
            if(i>0&&nums[i]==nums[i-1]){    //第一个出现的i之后，跳过重复的
                continue;
            }
            int j=i+1;      //相向而行
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];  
                if(sum<0){
                    j++;
                }else if(sum>0){
                    k--;
                }else{
                    List<Integer> list=new ArrayList<Integer>();    //固定第一个位置后，找到第一个答案
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    while(j<k&&nums[j]==nums[j+1])j++;    //去除第二个重复位置后继续找，
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }

}
