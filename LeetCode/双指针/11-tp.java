//这题two pointers，面积等于较小的高度乘(j-i)，保存最大值，当左边较小时，移动左边挡板，右边较小时移动右边档板

class Solution {
    public int maxArea(int[] height) {
        if(height.length==0){
            return 0;
        }
        int i=0,j=height.length-1;
        int max=0;
        while(i<j){
            max=Math.max(max,(j-i)*Math.min(height[i],height[j]));
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
    
}
