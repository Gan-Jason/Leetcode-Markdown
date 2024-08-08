//双指针，对向而行，分别找山顶，如果最后i和j的位置不在山顶，即i！=j｜｜j-i>1，则为false
//我的问题是，没有考虑清楚边界条件，即如果是单调递减或者递增的情况，因此要判断最后i！=length-1，j！=0


class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length<3)
            return false;
        int i=0,j=arr.length-1;
        if(arr[j]>=arr[j-1]||arr[i]>=arr[i+1])return false;   //可以一开始就判断是否存在单调增减的情况。
        while(i<arr.length-1&&arr[i]<arr[i+1])i++;
        while(j>1&&arr[j]<arr[j-1])j--;
        if(j-i>1||arr[i]==arr[i+1])
            return false;
        return true;
    }
}
