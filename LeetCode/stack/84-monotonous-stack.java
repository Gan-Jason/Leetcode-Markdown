//单调栈用法，用一个栈left/right维护当前左边/右边的单调增的柱子，比如当遍历到heights[i]时，left为[1,2,3,4],则如果heights[i]比栈顶元素大，那么4就是它左边第一个比他矮的柱子，
//heights[i]为高的矩形的宽不可能往左延伸了。继续把i入栈；
//如果heights[i]比栈顶元素小或者等于（这种情况矩形的宽都可以往左延伸），则栈中元素弹出栈，知道栈顶比i小，为的就是找到i左边第一个比他矮的柱子，找到后按照上述做法继续；
//这题还有一个关键就是利用哨兵，即给原数组的头和尾都增加一个虚拟元素，下标为-1，length。数值为0，这样并不影响计算，而可以更好的归纳，不用判断特殊情况。
//如果栈为空，则i的左边第一个比他矮的柱子就是-1下标的柱子
//同理，找到i右边比他矮的柱子，这次是从右往左遍历，同上
//最后得到两个数组，分别是每个元素往左边延伸第一个比他矮的柱子的下标，和往右延伸第一个比他矮的下标，两个数组的距离，即是heights[i]的宽，就可以计算每个矩形的面积了
class Solution {
    public int largestRectangleArea(int[] heights) {
        //1. 每题应该第一反应都是先想个暴力法，一是快速解题得到答案，二是优化可以从暴力解得到思路。这题暴力解超时了
        // int ans=0;
        // for(int i=0;i<heights.length;i++){
        //     int len=0;
        //     int left=i>0?i-1:i;
        //     int right=i<heights.length-1?i+1:i;
        //     while(left>=0&&heights[left]>=heights[i]&&i!=0){
        //         len++;
        //         left--;
        //     }
        //     while(right<heights.length&&heights[right]>=heights[i]&&i!=heights.length-1){
        //         len++;
        //         right++;
        //     }
        //     ans=Math.max(ans,(len+1)*heights[i]);
            
        // }
        // return ans;
        //2. monotonous stack，单调栈
        int ans=0;
        Deque<Integer> left=new ArrayDeque<>();
        int[] lh=new int[heights.length];
        int[] rh=new int[heights.length];
        Deque<Integer> right=new ArrayDeque<>();
        int i=0;
        for(;i<heights.length;i++){
            while(!left.isEmpty()&&heights[left.peek()]>=heights[i]){
                left.pop();
            }
            lh[i]=left.isEmpty()?-1:left.peek();
            left.push(i);
        }
        i--;
        while(i>=0){
            while(!right.isEmpty()&&heights[right.peek()]>=heights[i]){
                right.pop();
            }
            rh[i]=right.isEmpty()?heights.length:right.peek();
            ans=Math.max(ans,heights[i]*(rh[i]-lh[i]-1));
            right.push(i);
            i--; 
        }
        return ans;
    }
}
