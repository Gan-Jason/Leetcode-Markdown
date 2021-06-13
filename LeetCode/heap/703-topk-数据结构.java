//维护一个k大小的小顶堆即可，每次比堆顶大的值就入堆，否则直接返回堆顶，就是top k


class KthLargest {
    int[] heap;
    int size;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.heap=new int[k];
        int i=0;
        this.size=0;
        for(;i<k&&i<nums.length;i++){
            heap[i]=nums[i];
            size++;
        }
        if(size==k){    //如果达到k个元素时，再进行建堆。
            for(int j=size/2-1;j>=0;j--){
                shift(heap,j,size-1);
            }
            for(;i<nums.length;i++){    //nums超过k个元素，则作遍历判断是否能进堆
                if(nums[i]>heap[0]){
                    heap[0]=nums[i];
                    shift(heap,0,size-1);
                }
            }
        }
    }
    public int add(int val) {
        if(size==k){
            if(heap[0]<val){    //比堆顶大时才能进堆
                heap[0]=val;
                shift(heap,0,k-1);
            }
        }else{
            heap[size]=val;   //表明此时堆还没够k个元素
            size++;
            for(int i=size/2-1;i>=0;i--){
                shift(heap,i,size-1);
            }
        }
        return heap[0];
    }
    private void shift(int[] nums,int start,int end){
        int i=start,j=2*i+1;
        int t=nums[start];
        while(j<=end){
            if(j<end&&nums[j]>nums[j+1]){
                j++;
            }
            if(t>nums[j]){
                nums[i]=nums[j];
                i=j;
                j=2*j+1;
            }else{
                break;
            }
        }
        nums[i]=t;
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
