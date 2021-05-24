//这题是二分+贪心的变形，这里不用贪心了，直接找mid当作吃香蕉的速度k，然后计算吃完这堆需要多少小时，如果在给定的范围内，则符合条件，并移动right
//如果超过了时间范围，则是mid给小了，移动left
//这题要注意的地方是，计算时间，即总数/速度=时间，这里需要向上取整。如果不做向上取整的话，就需要自己分情况计算会比较麻烦。
//向上取整也会容易出错，Math.ceil()=(piles[i]-1)/mid+1,直接用ceil会出错

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1,right=0,mid;
        for(int i=0;i<piles.length;i++){
            right=Math.max(piles[i],right);
            left=Math.min(piles[i],left);
        }
        while(left<right){
            mid=left+(right-left)/2;
            if(check(piles,mid,h)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    private boolean check(int[] piles,int mid,int h){
        if(mid==0)return false;
        int hours=0;
        for(int i=0;i<piles.length;i++){
            hours+=(piles[i]-1)/mid+1;
            // if(piles[i]%mid==0){     //否则自己分情况讨论，当是可以整除时，不需要取整
            //     hours+=piles[i]/mid;
            // }else{   //否则取整
            //     hours+=piles[i]/mid+1;
            // }
            
        }
        return hours<=h;
    }
}
