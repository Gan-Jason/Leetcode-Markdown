//判断一个序列是否是一个BST的后序遍历，首先提取题目中的有效条件：
//BST，左子树比根节点小，右子树比跟节点大，只要违反了这个规则就不是BST
//后序遍历中，最后一个节点就是根节点。
//注意，判断时，找到左子树后还要继续遍历右边的序列，看看是否有比根节点小的，因为左边是全部小于根节点的。

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder==null)return false;
        if(postorder.length==0)return true;
        return dfs(postorder,0,postorder.length-1);
    }

    private boolean dfs(int[] postorder,int start,int end){
        if(start>=end){
            return true;
        }
        int i=start;
        while(i<end&&postorder[i]<postorder[end]){    //找出左子树的序列
            i++;
        }
        int j=i;
        while(j<end){     //关键，要继续判断右子树序列是否有效
            if(postorder[j]<postorder[end]){    //如果发现有比根节点小的，则无效
                return false;
            }
            j++;
        }

        return dfs(postorder,start,i-1)&&dfs(postorder,i,end-1);
    }
}
