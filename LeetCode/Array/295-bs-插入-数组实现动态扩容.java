//这题我是模仿了ArrayList的实现，用数组作为容器的数据结构，维护一个有序的数组，插入时通过binary search找到插入位置。
//插入时检查数组容量是否满足需求，不满足则扩容1.5倍，扩容时注意要是当前数组的长度扩容，我开始犯了错误用固定长度扩容
//代码比较长，所以细节比较多，要注意边界。比如bs时，要注意采用什么循环条件和指针移动，如果是left<right作为循环条件，则遇到插入元素比第一个小则需要特殊判断；否则就用left<=right;
//但这题用特殊判断会省时一点，只要比第一个小则直接返回，不需要再bs；此时mid的计算要小心死循环，因为如果取left=mid，则mid要取上半区，即mid=(right-left+1)>>1;
//位运算要比数学运算要快，lc的耗时结果相反，不用管。
//


class MedianFinder {

    private int[] value;

    private int size;

    /** initialize your data structure here. */
    public MedianFinder() {
        value=new int[100];
        size=0;
    }
    
    public void addNum(int num) {
        checkCapacity();
        if(size==0){
            value[0]=num;
        }else{
            int pos=binarySearch(num);
            System.arraycopy(value,pos+1,value,pos+2,size-pos-1);
            value[pos+1]=num; 
        }
        size++;

    }
    
    public double findMedian() {
        int mid=size>>1;
        if((size&1)==0){
            return ((double)value[mid-1]+(double)value[mid])>>1;
        }else{
            return (double)value[mid];
        }
    }
    private void checkCapacity(){
        if(size+1>value.length){
            resize();
        }
    }

    private int binarySearch(int num){
        int left=0,right=size-1;
        if(num<value[0]){   //特殊判断
            return -1;
        }
        while(left<right){
            int mid=left+(right-left+1)>>1;
            if(value[mid]==num){
                return mid;
            }else if(value[mid]>num){
                right=mid-1;
            }else{
                left=mid;
            }
        }
        return left;
    }
    private void resize(){
        int oldCapacity=value.length;
        int minCapacity=oldCapacity+oldCapacity<<1;  //扩容为原来1.5
        int[] newValue=new int[minCapacity];
        System.arraycopy(value,0,newValue,0,size);
        value=newValue;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */ 
