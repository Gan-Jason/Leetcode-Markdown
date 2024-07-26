/*
* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
*
**/

    //层次遍历二叉树，结果分层保存在二维数组中，分层保存就涉及当前层的问题，一个简单的方法就是用队列层次遍历，队列当前的结点数就是当前层的树节点数；
    //第二个办法就是我这种笨办法，先把层次遍历的结果全部保存在队列中，在遍历的过程中把当前层的结点数记录在一个数组中，之后再根据数组中的节点数去重新
    //存放结果数组
    List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        List<TreeNode> temp_ans=new ArrayList<>();
        Queue<TreeNode> qu=new LinkedList<>();
        
        TreeNode p;
        qu.add(root);
        //List<Integer> level=new ArrayList<>();
        int[] level=new int[780];
        level[1]=1;
        int i=1,num;
        //num标记当前层的结点数，level数组是每一层的结点数存放数组
        while(!qu.isEmpty()){
            num=level[i];
            //一层层的遍历，当前层的节点没有遍历完则继续
            while(num>0){
                p=qu.remove();
                temp_ans.add(p);
                //遍历完一个节点就减1
                num--;
                if(p.left!=null){
                    qu.add(p.left);
                    level[i+1]++;
                }
                if(p.right!=null){
                    qu.add(p.right);
                    level[i+1]++;
                } 
                if(num==0)
                    i++;
            }   
        }
        //x是标记temp_ans树节点数组的下标
        int x=0;
        
        for(int j=1;j<i;j++){
            List<Integer> temp=new ArrayList<>();
            for(int k=1;k<=level[j];k++){
                temp.add(temp_ans.get(x++).val);
            }
            ans.add(temp);

        }
        return ans;

    }
