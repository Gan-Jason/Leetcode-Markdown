//这题也属于同向tp，i选择为1，j也选择为1，i更新为j的位置
//考虑边界情况
//把各种情况归纳一下，有一些是可以合并的，只要把思路理清楚了



class Solution {
    public int maxDistToClosest(int[] seats) {
        int max=0;
        int i=0,j=0;
        while(j<seats.length){
            while(j<seats.length-1&&seats[j]!=1)j++;
            if(seats[i]==0){        //此时j只能为1或者到了数组末位，如果seat[i]为0，则j必为1
                max=Math.max(max,j-i);
            }else{  //seat[i]为1
                if(seats[j]==0){   //如果此时j为0
                    max=Math.max(max,j-i);
                }else{
                    max=Math.max(max,(j-i)>>1);
                }
            }
            i=j;
            j++;
        }
        return max;
    }
}
