//第一思路，DFS，但这里我第一次想法是bottom up，即把所有路径的字符串都列出来，最后累加，但是这样比较麻烦，每个节点有三个情况：1. 有左子树，左子树还可能具有两个路径；2. 有右子树，
// 右子树可能具有两个路径；3. 无子树，只加自己本身；
// 如果bottom up不行，就尝试top down，只需要把累加值往下传，并用一个全局变量做路径值累加（只有是叶子节点的时候才计算），这里一个小难点就是当父节点传值给子节点的时候如何做累加：
// 父节点是高一位，因此传下来的值只需要*10即可，sum+=sum*10；

class Solution {
    private int gSum=0;
    public int sumNumbers(TreeNode root) {
        getSum(root,0);
        return gSum;
    }
    
    public void getSum(TreeNode root,int sum){
        if(root==null)return;
        sum=sum*10+root.val;                //sum作为当前的一个路径值
        if(root.left==null&&root.right==null){    //叶子节点做计算
            gSum+=sum;
        }
        getSum(root.left,sum);
        getSum(root.right,sum);
        
    }
}

//还有一种DFs思路是，top down用字符串保存路径，在叶子节点进行字符串路径计算，这个思路的话需要在递归返回上一层时把当前的路径字符串去掉最后一位，即去掉当前的节点值。

class Solution {
    private String path_num="";
    private int result=0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        calculatePath(root);
        return result;
    }
    private void calculatePath(TreeNode root){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            path_num+=root.val;
            result+=Integer.parseInt(path_num);
            path_num=path_num.substring(0,path_num.length()-1);
            return;
        }
        path_num+=root.val;
        calculatePath(root.left);
        calculatePath(root.right); 
        path_num=path_num.substring(0,path_num.length()-1);
    }
}
