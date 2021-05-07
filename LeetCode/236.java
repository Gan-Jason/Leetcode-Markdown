// 思路一：在一棵普通的二叉树要找到最低的公共祖先节点，可把从根节点到目标节点的路径用数组保存为链表，从而转化为找出两个链表的最大下标相同节点
// 该思路难点1，把路径串成链表，一开始我的想法是用链表节点去串，后来发现只用数组即可；遍历可采用前序遍历，用一个标记位记录是否找到目标节点，若找到不再遍历左右子树，若没找到：1.继续遍历子树
//2. 左子树没找到把path最后一个节点删除，返回上一层，继续遍历右子树。
// 优化：一开始我是进行两次遍历得到两个目标节点的path，优化后可在一次前序遍历中获得两个path；得到两个path后，从后往前找第一个相同的节点比由前往后找最后一个相同的要快


class Solution {
    boolean pFound=false;
    boolean qFound=false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;
        List<TreeNode> pPath=new ArrayList();
        List<TreeNode> qPath=new ArrayList();
        dfs(root,p.val,q.val,qPath,pPath);
        TreeNode ans=null;
        for(int i=Math.min(qPath.size()-1,pPath.size()-1);i>=0;i--){    //从后往前
            if(pPath.get(i)==qPath.get(i)){
                ans=pPath.get(i);
                break;
            }
        }
        return ans;
    }
    
    public void dfs(TreeNode root, int p,int q,List<TreeNode> qPath,List<TreeNode> pPath){    //一次前序遍历
        if(root==null)return;
        if(!pFound)   //pPath没找到才存当前节点
            pPath.add(root);
        if(!qFound)
            qPath.add(root);
        if(root.val==p){
            pFound=true;
        }
        else if(root.val==q){
            qFound=true;
        }
        if(!pFound||!qFound){   //只要一个没找到就继续找
            dfs(root.left,p,q,qPath,pPath);
        }
        if(!pFound||!qFound){
            dfs(root.right,p,q,qPath,pPath);
        }
        if(!pFound){    //叶子节点时还未找到path，返回上一层前，要删除当前层节点。
            pPath.remove(pPath.size()-1);
        }
        if(!qFound){
            qPath.remove(qPath.size()-1);
        }

        
    }
    
    
}
