//经典回溯题，找出所有的排列情况，
//因为是排列，每个位置都是可以选的，但是选过的元素就不能再用了，所以可以用一个标记数组对应原数组nums，每个位置上只要选过了就标记为true，这样递归下去的时候也可以看到该标记表明该元素已经被其他
//位置用过了
class Solution {
    private List<List<Integer>> ans;
    private int[] nums;
    private boolean[] tag;
    public List<List<Integer>> permute(int[] nums) {
        ans=new ArrayList<>();
        tag=new boolean[nums.length];
        this.nums=nums;
        dfs(new ArrayList<Integer>());
        return ans;
    }

    private void dfs(List<Integer> list){

        if(list.size()==nums.length){   //base case
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(tag[i]==false){    //只有当原数组i位置没有被选过的时候，才能被当前位置选中
                list.add(nums[i]);
                tag[i]=true;
                dfs(list);
                tag[i]=false;
                list.remove(list.size()-1);
            }

        }
    }
}
