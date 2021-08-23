//这题暴力dfs会超时，因此需要剪枝
//根据节点数量进行剪枝



class Solution {
    public int findKthNumber(int n, int k) {
        long cur = 1;
        k -= 1;

        while(k > 0){
            int nodes = getNodes(n, cur);
            if(k >= nodes){
                k -= nodes;
                cur++;      //go right
            }else{
                k -= 1;
                cur *= 10;  //go down
            }
        }

        return (int)cur;
    }

    private int getNodes(int n, long cur){
        long next = cur + 1;
        long totalNodes = 0;
        
        while(cur <= n){
            totalNodes += Math.min(n - cur + 1, next - cur);    //计算当前层的节点数，要先判断节点是否能长到隔壁堂兄弟，如果当前层的兄弟节点都要比n大了，就不会长出隔壁堂兄弟来

            next *= 10;
            cur *= 10;
        }

        return (int)totalNodes;
    }
}
