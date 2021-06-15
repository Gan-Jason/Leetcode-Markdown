//这题有一点绕，hashmap存的是前n个子序列的和，记为sumx,如果sumx-k存在于map中，则表示当前的sumx减去某个子序列后可以得到k，则答案出现为ans+map.get(sum-k)次
//我想不明白是，ans怎么计算，是每次出现了sumx-k就累加一次还是map.get(sum-k)+1，这里要搞明白map存的sum-k的含义是什么，以及如何更新它
//每次是把当前的sum记录于map中，如果map中存在了，则累加一次，表示：当前的sum可以出现n次，分别是不同的子序列的
//当sum-k存在于map中时，表示：k=sum-(sum-k),则出现的次数就是ans+map.get(sum-k)，因为这是不用子序列的出现次数记录值，所以可以出现的次数要加上之前出现的不同次数；
//最后再更新sum，不能在开始更新sum的原因是，有可能这次的sum是出现过的，那就必须先更新了ans才能更新sum：ans的更新必须是累加新的sum去减旧的sum出现的次数，当前的sum虽然可能出现了，
//但是没有新的sum去减自己，所以不能把当前的sum算入答案中，否则就多加了。

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>(20000);  //初始化容量比较省时，省去了扩容的消耗
        map.put(0,1); //这个是作为第一次出现sum=k的情况，而创造的条件
        int ans=0,sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];   //计算当前sum
            if(map.containsKey(sum-k)){   //子序列的sum用减法，即sumy-sumx=sum[x,y],如果
                ans+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1); //要先更新ans才能更新map，防止如果当前sum已存在map中，就会多加了一次，因为sum是要被后来的sum减的，当前的sum不能作为答案
            
        }
        return ans;
    }
}
