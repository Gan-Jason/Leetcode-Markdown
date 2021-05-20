//要利用题目的条件，这题的数组里元素都是数组存在的下标+1，可以利用这个条件，先把第一次出现的数在它的下标位置用负数标记，表明已经出现一次
//继续遍历如果存在相同的数，则一定是相同的下标，去该下标找值时发现是负数，则该数已出现两次，加入答案

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        if(nums.length<=1){
            return new ArrayList<Integer>();
        }
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int t=Math.abs(nums[i]);    //获取当前位置元素绝对值
            if(nums[t-1]<0){        //计算元素对应的下标，并判断是否为负数，如果是，则t已经出现两次
                list.add(t);
            }
            nums[t-1]=-nums[t-1];   //把t对应的下标置为负数。
        }

        return list;
    }
}
