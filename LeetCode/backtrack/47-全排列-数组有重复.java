//这题有重复元素，但是答案不能出现重复的排列数，因此要去重，
//关键点在去重的时机，应当在每一层的开始进行去重，即，只要当前位置前面的位置都确定了，那么当前位置应该是不能出现重复数字的，否则就是重复排列了，当前层遇到已经用过的数字就跳过即可

class Solution {
    private List<List<Integer>> ans;
    private int[] nums;
    private boolean[] tag;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans=new ArrayList<>();
        tag=new boolean[nums.length];
        this.nums=nums;
        dfs(new ArrayList<Integer>());
        return ans;
    }
    private void dfs(List<Integer> list){

        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        Set<Integer> set=new HashSet<>();   //在每一层/每个位置上进行去重
        for(int i=0;i<nums.length;i++){
            if(tag[i]==false&&set.add(nums[i])){    //在前面位置固定的情况下，当前位置已经用过该数字，则不再考虑
                list.add(nums[i]);
                tag[i]=true;
                dfs(list);
                tag[i]=false;
                list.remove(list.size()-1);
            }

        }
    }
}
