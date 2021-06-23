//全组合就是不需要重复的排列，只需要组合
//每个位置都只有两种选择，选还是不选，因此这里会涉及回溯（是回溯吗？），选了之后回来后要擦除，恢复原状态
//如果是排列的话，每个位置就有所有的组合（如果是不重复的排列的话，这里就要用hashset去重当前位置）
//难点，base case check条件是什么，为什么要index为length时终止，因为这表明当前已经对整个数组的元素选完了
class Solution {
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        
        dfs(nums,new ArrayList<>(),0);
        return ans;
    }
    private void dfs(int[] nums,List<Integer> list,int index){
        if(index==nums.length){   //base case check
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs(nums,list,index+1);
        list.remove(list.size()-1);   //擦除
        dfs(nums,list,index+1);
    }
    
}
