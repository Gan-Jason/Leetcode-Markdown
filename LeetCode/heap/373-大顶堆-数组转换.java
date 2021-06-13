//这题主要时间花在数组与list的转换上了
//不想用两层for循环写，List，Arrays等工具类APi研究许久
//记住常用的即可:
//一维数组转List：List l=Arrays.asList(new Integer[]{1,2,3});
//二维数组转List:List matrix=new ArrayList().addAll(Arrays.asList(new Integer[]{1,2,3})); //这只是一行，实现多行的二维数组要一个for循环
//List转一维数组：int[] arr=list.toArray(new int[0]); //List会对该方法的参数数组的长度进行判断的，比size小则返回size长度
//List转二维数组：int[][] arr=list.toArray(new int[0][]);

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int[][] heap=new int[k][2];
        int count=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(count<k){
                    heap[count][0]=nums1[i];
                    heap[count][1]=nums2[j];
                    count++;
                    if(count==k){
                        for(int p=k/2-1;p>=0;p--){
                            shift(heap,p,k-1);
                        }
                    }
                }else{
                    if(heap[0][0]+heap[0][1]>nums1[i]+nums2[j]){
                        heap[0][0]=nums1[i];
                        heap[0][1]=nums2[j];
                        shift(heap,0,k-1);
                    }
                }
            }
        }
        List ans=new ArrayList();
        
        for(int i=0;i<count;i++){
            List t=Arrays.asList(new Integer[]{Integer.valueOf(heap[i][0]),Integer.valueOf(heap[i][1])});
            ans.add(t);
        }
        return ans;
    }
    void shift(int[][] nums,int start,int end){
        int i=start,j=2*i+1;
        int[] t=nums[start];
        int sum=t[0]+t[1];
        while(j<=end){
            if(j<end&&nums[j][0]+nums[j][1]<nums[j+1][0]+nums[j+1][1]){
                j++;
            }
            if(sum<nums[j][0]+nums[j][1]){
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
