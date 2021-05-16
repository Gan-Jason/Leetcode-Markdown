//1.本题暴力法的话，从i=1开始遍历，每个元素找到最左边的最高档板，和最右边的最高档板，取两者的较小值减去当前位置的height，即是当前位置的储水量。当前位置储水量取决于左右两块档板的高度，和本身的高度
//把每个位置的储水量相加即是答案，时间复杂度为O(n^2)
//2.动态规划，用两个数组分别记录每个元素左边的最高档板和右边的最高档板，然后利用两个数组的记录，计算当前位置的储水量，其实算法是和暴力法的思路一致，只是dp会把需要用到的数据保存下来供其他元素使用
//省去了嵌套循环的时间花销，时间复杂度为O(n)
//3.双指针。左右指针交替遍历，如果左边的最高档板比右边的低，则判断当前位置与左边最大档板的差值，若当前位置比左边最高低，则可以储水max-cur_height，左指针+1，并更新左边最高档板数值；如果是右边
//档板比左边最大档板低，则判断右边并移动右指针

class Solution {
    public int trap(int[] height) {
        if(height.length==0){
            return 0;
        }
        int i=0,j=height.length-1;
        int sum=0;
        int maxLeft=height[0],maxRight=height[j];
        while(i<j){
            if(maxLeft<maxRight){
                if(height[i]<maxLeft){
                    sum+=maxLeft-height[i];
                }
                i++;
                maxLeft=Math.max(maxLeft,height[i]);
            }else{
                if(height[j]<maxRight){
                    sum+=maxRight-height[j];
                }
                j--;
                maxRight=Math.max(maxRight,height[j]);
            }
        }
        return sum;
    }
}
