//这题也属于top k，只是有点变形，难点在于对一个质数/合数，因数等概念的转化为计算机语言，
//丑数的基数是2，3，5，如果一个数是丑数，则它是由基数乘另一个丑数得到，反证法可以证明。所以只需要遍历整数中的丑数即可，从2，3，5乘上一个丑数迭代得到所有的丑数，
//如：2，3，5，2*2，2*3，2*5，3*2，3*3，3*5...
//维护一个小顶堆，堆顶是最小的丑数，每次弹出一个丑数，得到下三个丑数并压入堆中，弹出n次，则第n个丑数就出来了。



class Solution {
    public int nthUglyNumber(int n) {
        if(n==1){
            return 1;
        }
        Set<Long> seen=new HashSet<>();
        // long[] heap=new long[3*n+1];
        // int head=0,tail=1;
        // heap[0]=1L;
        // seen.add(1L);
        // long t=0;
        // while(n>0){
        //     boolean tag=false;
        //     t=heap[0];
        //     n--;
        //     if(!seen.contains(t*2)){
        //         seen.add(t*2);
        //         heap[0]=t*2;
        //         tag=true;
        //     }
        //     if(!seen.contains(t*3)){
        //         seen.add(t*3);
        //         if(tag){
        //             heap[tail++]=t*3;
        //         }else{
        //             heap[0]=t*3;
        //             tag=true;
        //         }
        //     }
        //     if(!seen.contains(t*5)){
        //         seen.add(t*5);
        //         if(tag){
        //             heap[tail++]=t*5;
        //         }else{
        //             heap[0]=t*5;
        //             tag=true;
        //         }
        //     }
        //     int end=tail-1;
        //自己实现的heap耗时比较大，原因在于这里，每次都要重新调整整个堆，相当于每次都重新建堆，因为这里不仅是改了堆顶，还增加了叶子节点
        //如果是一个建好的堆，只改了堆顶元素，则只需要调整一次，就是调整堆顶的元素至合适位置
        //     for(int i=end/2-1;i>=0;i--){
        //         shift(heap,i,end);
        //     }
            
    //}
        //用PQ
        PriorityQueue<Long> pq=new PriorityQueue<Long>();
        pq.offer(1L);
        seen.add(1L);
        long t=0;
        while(n>0){
            t=pq.poll();
            n--;
            if(!seen.contains(t*2)){
                seen.add(t*2);
                pq.offer(t*2);
            }
            if(!seen.contains(t*3)){
                seen.add(t*3);
                pq.offer(t*3);
            }
            if(!seen.contains(t*5)){
                seen.add(t*5);
                pq.offer(t*5);
            }
        }

        return (int)t;
    }
    private void shift(long[] nums,int start,int end){
        int i=start,j=start*2+1;
        long t=nums[start];
        while(j<=end){
            if(j<end&&nums[j]>nums[j+1]){
                j++;
            }
            if(nums[j]<t){
                nums[i]=nums[j];
                i=j;
                j=j*2+1;
            }else{
                break;
            }
        }
        nums[i]=t;
    }
}
