/*
* Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
* 
* Note: The solution set must not contain duplicate subsets.
**/



class Solution {
    //回溯法解决含有重复元素的组合问题
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> sub=new ArrayList<>();
        //需要排序，以便于后面判断是否已经存在重复的子集
        Arrays.sort(nums);
        backTrack(sub,new ArrayList<Integer>(),0,nums);
        return sub;
    }   
    void backTrack(List<List<Integer>> sub,ArrayList<Integer> temp,int start, int[] nums){
        //任意长度的组合数就不需要判断长度了，直接压进数组
        sub.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++){
            //如果i>start说明已经在递归中压进数组了，就无需再重复压入；若nums的相邻两位是重复的，同理也是递归下一个递归已经处理
            if(i > start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            backTrack(sub, temp, i+1, nums);
            temp.remove(temp.size()-1);

        }
    }
}
