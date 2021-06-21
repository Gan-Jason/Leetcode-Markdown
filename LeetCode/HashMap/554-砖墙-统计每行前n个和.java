//这题思路竖了，想到是统计前n和，然后统计最大的能对齐的和的个数。但是我用的是竖着来遍历，即固定列，遍历每行，这样导致不能控制每行的个数保证一致，因为最后一个数不需要遍历
//每行的个数不一致就很麻烦，卡在了这里，如何控制每行在不一致个数情况下只遍历到倒数第二个
//竖着难搞，就转变思想，遍历每一行，这样可以控制每行遍历的个数，遍历每行需要把前n个和出现次数累计map中，最后找出出现次数最多的值，就是能对齐最多的情况
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=wall.size();
        for(int i=0;i<n;i++){
            int m=wall.get(i).size();
            int sum=0;
            for(int j=0;j<m-1;j++){
                sum+=wall.get(i).get(j);
                map.put(sum,map.getOrDefault(sum, 0)+1);
            }
        }
        int ans=0;
        for(Iterator<Map.Entry<Integer,Integer>> it=map.entrySet().iterator();it.hasNext();){
            Map.Entry<Integer,Integer> e=it.next();
            ans=Math.max(ans,e.getValue());
        }
        return n-ans;
    }
    
}
