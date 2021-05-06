//这题思路一开始想法是：计算节点的sum，这里可以用bottom up，计算左右子节点然后加root.val，把每个节点的sum存入list中，然后在list中找到频率最高的结果
// 我的想法是，对list排序，再遍历list，找到最高频的sum序列，方法是可行的，但是时间花销太大，要排序list再遍历它，加上计算sum的递归，性能较差

class Solution {
    List<Integer> list=new ArrayList<Integer>();
    
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> ans=new ArrayList<>();    //ans用于保存最高频的序列
        Collections.sort(list);       //排序耗费。。
        int mF=0;
        for(int i=0;i<list.size()-1;i++){
            int cur=list.get(i);      //这里留一个问题，如果是写if(list.get(i)==list.get(i+1))会有问题，这么写是没问题。。
            if(cur==list.get(i+1)){   //如果有相同的，则累加相同个数
                int j=1;
                while(i<list.size()-1&&list.get(i)==list.get(i+1)){
                    i++;
                    j++;
                }
                if(mF<j){   //当前的相同个数比之前记录的最高频mF要大，则用另一个list保存结果，
                    ans.clear();
                    ans.add(list.get(i));
                    mF=j;
                }
                else if(mF==j){   //如果跟之前最高频一样次数，则也用ans保存sum
                    ans.add(list.get(i));
                }
            }
        }
        
        if(ans.size()==0)return list.stream().mapToInt(i->i).toArray();
        return ans.stream().mapToInt(i->i).toArray();

        

    }
    
    private int dfs(TreeNode root) {
        if(root==null)return 0;
        int sum=root.val+dfs(root.left)+dfs(root.right);
        list.add(sum);
        return sum;
    }
}





class Solution {    //别人的思路
    int maxFreq = 0;
    int count = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();    //用map保存sum的结果，key为sum，value为频率
        traverse(root, map);
        int[] res = new int[count];   //根绝序列长度初始化数组
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {    
            if (entry.getValue() == maxFreq) {    //根据频率判断当前sun是否为最高频
                res[i++] = entry.getKey();
            }
        }
        return res;
    }
    
    private int traverse(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        
        int left = traverse(root.left, map);
        int right = traverse(root.right, map);
        
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);     //map记录当前的sum以及频率，
        if (map.get(sum) > maxFreq) {   //如果当前sum的频率比之前记录的高，代表这个sum是最高频，并只有一次出现
            maxFreq = map.get(sum);
            count = 1;
        } else if (map.get(sum) == maxFreq) {   //如果和之前频率相等，则这个sum为相同高频数，序列长度+1
            count++;
        }
        return sum;
    }
}
