//错误：想用一个数组存储数组元素出现次数，再一次遍历找出连续的序列，但是原数组中存在负数，因此不适用
//这题也想过用hashmap，但不知道怎么遍历map找出连续序列
//可以对于每个数，查找map中是否存在这个数的下一位数，存在则一直找出来
//如果这样的话，会有一种情况，就是重复查找，比如1，2，3，4，5，当从1开始找，找到5结束，继续遍历原数组，从2开始找，又找了一遍，3开始...这里重复计算
//这样的重复计算是无效的，因为任何从1后面开始找的都不会比从1开始找的答案长，因此需要排除掉后面的，如何排除呢？
//发现1左边是没有数了，2左边有1，3左边有1，2..因此判断条件就是当前元素x，map中不存在x-1则查找，如果存在则不查找，这样同一个序列范围只需要查找一次
//这里map的value不需要，用set即可

class Solution {
    public int longestConsecutive(int[] nums) {
        int len=nums.length;
        if(len<=1){
            return len;
        }
        Set<Integer> set=new HashSet<>(1500);
        for(int i=0;i<len;i++){
            set.add(nums[i]);
        }
        int ans=1;
        for(int num:set){   //去重后，只需要遍历这个集合即可
            if(set.contains(num-1)){
                continue;
            }else{
                int t=num;
                if(set.contains(t+1)){
                    int j=1;
                    while(set.contains(t+1)){
                        t++;
                        j++;
                    }
                    ans=Math.max(ans,j);
                }
            }
        }
        return ans;
    }
