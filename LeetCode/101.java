/* 
* 1. 第一个思路，层次遍历并用数组存放每一层的结果，空节点用-1代替，当层次遍历第一层后，对这个数组进行遍历，如果第i个和第length-1-i个的值不相等则返回false。此思路的缺点是有两个for循环导致时间
* 花销较大；此思路实现上难点：如何确保用-1替代空节点又不会导致遍历过程中空指针异常，（有一个思想，选择在当前状态判断/操作还是下一个状态判断/操作是一个关键点，
* 选择在对当前操作还是对子操作也是一个关键点），
*/
// 第一个思路
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> ml=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur==null){    //对当前操作
                    ml.add(-1);
                    
                }else{
                    ml.add(cur.val);
                }
                if(cur!=null){            //把下层的双节点不管是否为空都放进队列里，避免出现下层节点遗漏的情况；
                                          //如果下层全是空节点，循环在下层结束，因为只有在当前节点不为空才能继续把字节点压进队列
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }

            }
            for(int i=0;i<ml.size()/2;i++){
                if(ml.get(i)!=ml.get(size-1-i))return false;
            }
        }
        return true;
    }
}


// 第一个思路错解
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> ml=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                ml.add(cur.val);    //全部节点的值都存入数组，会导致数组中分不清是左节点还是右节点的值，从而导致[1,2,2,null,3,null,3]返回true
                if(cur.left!=null)queue.offer(cur.left);
                if(cur.right!=null)queue.offer(cur.right);
            }
            for(int i=0;i<ml.size();i++){
                if(ml.get(i)!=ml.get(size-1-i))return false;
            }
        }
        return true;
        
    }
}

//第二个思路，不用数组存放每个层次结果，只需要层次遍历时，分别用左队列和右队列进行节点存放，当弹出左队列的节点与右队列的节点不是镜像时，返回false

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        Queue<TreeNode> queueL=new LinkedList<>();
        Queue<TreeNode> queueR=new LinkedList<>();
        queueL.offer(root);
        queueR.offer(root);
        while(!queueL.isEmpty()){
            int size=queueL.size();
            List<Integer> ml=new ArrayList<>();
                TreeNode curL=queueL.poll();
                TreeNode curR=queueR.poll();
                if(curL!=null&&curR!=null){
                    if(curL.val!=curR.val)
                        return false;
                }
                else if(curL==null&&curR==null){    //这里的判断有点乱，应该是1. 都是空 2. 其一是空：if(L==null||R==null) 3. 都不是空，到这里直接判断值即可
                    continue;
                }else{
                    return false;
                }
                if(curL!=null){           //其实这里没必要判断，上面已经把这个情况过滤了
                queueL.offer(curL.left);
                queueL.offer(curL.right);
                }
                if(curR!=null){
                queueR.offer(curR.right);
                queueR.offer(curR.left);
                }


        }
        return true;
    }
}
