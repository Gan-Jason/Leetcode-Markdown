/* 第一种思路：层次遍历，根据每一层的节点下标判断找到的x，y是否为同一个父节点：层次遍历把所有子节点包括null都压入队列中，在每一层中找x，y，若存在则判断x下标和y下标，如果其一是偶数，
* 则另一个不能是其右侧紧挨节点，否则返回false（同一个父节点）；其它其情况则返回true。因为一个满二叉树，每一个左子节点的下标都是偶数，
* 当两个节点是同一个parent的时候必然是奇数下标-偶数下标==1这一种情况
*
*/

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int xi=-1,yi=-1;
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                if(cur!=null){
                    if(cur.val==x)xi=i;
                    if(cur.val==y)yi=i;
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }
            if(xi!=-1&&yi!=-1)
            {
                if(xi%2==0&&yi-xi==1||yi%2==0&&xi-yi==1){   //判断在同一个层中，唯一为同一个parent情况
                    return false;
                }else{
                    return true;
                }
            }
            
        }
        return false;   //本树中不存在同一个层的x和y
        
    }
}


// BFS节约空间方法
public boolean isCousins(TreeNode root, int A, int B) {
    if (root == null) return false;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.offer(root);
	while (!queue.isEmpty()) {
		int size = queue.size();
		boolean isAexist = false;		    //此处只用了一个字节
		boolean isBexist = false;		
		for (int i = 0; i < size; i++) {
			TreeNode cur = queue.poll();
            if (cur.val == A) isAexist = true;         //找出本层的x，y，同一个parent的情况已经在上一层中过滤，因此只要本层中出现x，y即可返回true
            if (cur.val == B) isBexist = true;
			if (cur.left != null && cur.right != null) {    //在本层中判断下层的x，y是否为同一个parent
				if (cur.left.val == A && cur.right.val == B) { 
					return false;
				}
				if (cur.left.val == B && cur.right.val == A) { 
					return false;
				}
			}
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			if (cur.right != null) {
				queue.offer(cur.right);
			}
		}
		if (isAexist && isBexist)  return true;
	}
	return false;
}
