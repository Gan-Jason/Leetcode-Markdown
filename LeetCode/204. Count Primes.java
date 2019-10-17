class Solution {
    public int countPrimes(int n) {
        if(n<3){
            return 0;
        }
        int ans=0;
        for(int j=3;j<n;j++){
            int sqrt=(int)Math.sqrt((double)j);
            int i;
            for(i=2;i<=sqrt;i++){
            if(j%i==0)
                break;

        }
            if(i>sqrt)
                ans++;
        }
        return ans+1;
    }
}
