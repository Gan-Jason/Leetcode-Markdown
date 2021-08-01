//这题比较典型，可以用partition(快选)也可以用堆
//快选需要改变原数组，时间复杂度为o(n)
//堆的话，需要建一个k个数的大顶堆，然后继续遍历后面的数，遇到比堆顶小的就加入堆，这样前k小的数就在堆中。复杂度为nlogk，
//用堆需注意，如果用小顶堆的话需要建整个数组的堆，复杂度为nlogn

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null)return null;
        int len=arr.length;
        int index=quick(arr,0,len-1);
        int start=0,end=len-1;
        while(index!=k){    //快选，直到找到选择的k，k左边都是比k小，k右边都是比k大
            if(index>k){    //如果选择的index比k大，则说明k在index左侧，有点分区间查找的意思
                end=index-1;
                index=quick(arr,start,end);
            }else{
                start=index+1;
                index=quick(arr,start,end);
            }
        }
        return Arrays.copyOf(arr,k);
        // for(int i=k/2-1;i>=0;i--){   //建堆
        //     shift(arr,i,k-1);
        // }
        // int pos=0;
        // for(int i=k;i<arr.length;i++){   //维护一个k个数的大顶堆
        //     if(arr[i]<arr[0]){
        //         arr[0]=arr[i];
        //         shift(arr,0,k-1);
        //     }
        // }
        // return Arrays.copyOf(arr,k);
    }
    private int quick(int[] arr,int start,int end){   //快选
        if(start>end){
            return start;
        }
        int i=start,j=end;
        int target=arr[i];
        while(i<j){
            while(i<j&&arr[j]>=target){
                j--;
            }
            if(i<j)
                arr[i]=arr[j];
            while(i<j&&arr[i]<=target){
                i++;
            }
            if(i<j)
                arr[j]=arr[i];
        }
        arr[i]=target;
        return i;
    }


    private void shift(int[] ary,int start,int end){    //大顶堆调整，start到end
        int i=start;
        int j=2*i+1;
        int target=ary[i];
        while(j<=end){
            if(j<end&&ary[j]<ary[j+1]){
                j++;
            }
            if(ary[j]>target){
                ary[i]=ary[j];
                i=j;
                j=2*j+1;
            }else{
                break;
            }
        }
        ary[i]=target;
    }
}
