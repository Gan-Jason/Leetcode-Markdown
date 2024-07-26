// 1. 正常的层次遍历
class Solution {
    public int maxDepth(Node root) {
        if(root==null)return 0;
        int depth=0;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node cur=queue.poll();
                int length=cur.children.size();
                if(length>0){
                    for(int j=0;j<length;j++){
                        queue.offer(cur.children.get(j));
                    }
                }
            }
            depth++;
        }
        return depth;
        
    }
    
}

// 2. 考虑深度优先，思路：没有子节点时且当前不为空，depth=1；有子节点时，children.size()>0则depth+1；一个节点的深度为1+max（孩子深度）

class Solution {
    public int maxDepth(Node root) {
        if(root==null)return 0;
        return 1+getDepth(root.children);

    }
    
    int getDepth(List<Node> root){
        if(root.size()==0)return 0;
        List<Integer> depth=new ArrayList<>();
        for(int i=0;i<root.size();i++){
            depth.add(1+getDepth(root.get(i).children));    //这里不够清晰，刚开始的思路是把所有孩子的depth放到一个list里然后挑出最大那个，其实不用，选最大值可以边比较边循环，
                                                            //比如：int depth=0;for(children->parent) depth=max(depth,maxDepth(children));
        }
        Collections.sort(depth);
        return depth.get(depth.size()-1);

    }
    
}
