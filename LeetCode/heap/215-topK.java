//求top k第一反应用堆，当然排序也可以，
//大顶堆，一次性建好堆后，poll k次，复杂度为 O(knlogn)
//小顶堆，维护一个k个元素的小顶堆，继续遍历原数组，遇到比堆顶大的就入堆，当堆内超过k个时，弹出堆，时间复杂度O((n+k)logk);自己实现的堆复杂度为o((n+k)logk)，用PriorityQueue则是o(knlogk)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len=nums.length;
        if(len==1){
            return nums[0];
        }
        // PriorityQueue<Integer> pq=new PriorityQueue<>();
        // pq.offer(nums[0]);
        // for(int i=1;i<len;i++){
        //     if(nums[i]>pq.peek()||pq.size()<k){
        //         pq.offer(nums[i]);
        //     }
        //     if(pq.size()>k){
        //         pq.poll();
        //     }
        // }
        // return pq.poll();
        //自己实现堆
        int[] heap=new int[k];
        int i=0;
        for(;i<k;i++){
            heap[i]=nums[i];
        }
      //初始化堆
        littleHeap(heap,0,k-1);
        for(;i<len;i++){
            if(nums[i]>heap[0]){    //遇到比堆顶大的数，则直接覆盖堆顶，相当于堆顶出堆
                heap[0]=nums[i];
                shift(heap,0,k-1);  //重新调整堆
            }
        }
        return heap[0];
    }
    void littleHeap(int[] num,int start,int end){
        int len=end-start+1;
        for(int i=len/2-1;i>=0;i--){
            shift(num,i,end);
        }
    }
    void shift(int[] num,int start,int end){
        int i=start,j=2*i+1;    //j为左孩子
        int t=num[start];
        while(j<=end){
            if(j<end&&num[j]>num[j+1]){ //当j<end时，必有右孩子
                j++;
            }
            if(t>num[j]){
                num[i]=num[j];
                i=j;
                j=2*i+1;
            }
            else{
                break;
            }
        }
        num[i]=t;   //最后i的位置就是start合适的位置
    }
}
