//这题属于top k稍微变形
//先用hashmap统计出现频率，再建小顶堆，堆元素用Map.EntrySet

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len=nums.length;
        if(len==1){
            return nums;
        }
        Map<Integer,Integer> fre=new HashMap<>();
        for(int i=0;i<len;i++){
            fre.put(nums[i],fre.getOrDefault(nums[i],0)+1);   //统计频率
        }
        Map.Entry[] fq=new Map.Entry[k];    //堆数组
        int j=0;
        Iterator it=fre.entrySet().iterator();
        for(;j<k;j++){
            fq[j]=(Map.Entry)it.next();
        }
        heap(fq,0,k-1);   //初始化堆
        for(;it.hasNext();){    //继续遍历剩下的entry
            Map.Entry t=(Map.Entry)it.next();
            if((Integer)t.getValue()>(Integer)fq[0].getValue()){    //如遇到比堆顶大的，则覆盖堆顶，重新调整堆
                fq[0]=t;
                shift(fq,0,k-1);
            }
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=(Integer)fq[i].getKey();
        }
        return ans;
    }
    void heap(Map.Entry[] nums,int start,int end){
        int len=end-start+1;
        for(int i=len/2-1;i>=0;i--){
            shift(nums,i,end);
        }
    }
    void shift(Map.Entry[] nums,int start,int end){
        int i=start,j=i*2+1;
        Map.Entry t=nums[start];
        while(j<=end){
            if(j<end&&(Integer)nums[j].getValue()>(Integer)nums[j+1].getValue()){
                j++;
            }
            if((Integer)t.getValue()>(Integer)nums[j].getValue()){
                nums[i]=nums[j];
                i=j;
                j=2*i+1;
            }
            else{
                break;
            }
        }
        nums[i]=t;
    }
}
