//我的做法是先把区间插入到原数组中，形成一个新的数组，再通过合并有序区间的做法得到答案，这样的话是两次遍历，时间复杂度也是o(n)，但是空间复杂度就是o(n)


//合并区间要点，两个区间it[i,j],it[left,right]是否有交集(区间内有序)：如果left>j或者right<i则两个区间必无交集，其他情况则是有交集
//在一个无交集的有序区间内插入一个区间new[left,right]时，可以先找到所有与new有交集的区间，合并这些区间并更新到new中，如果无交集的区间，则直接加入答案；
//当new[right]<old[left]时，再把new加入答案中，空间复杂o(1)


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len=intervals.length;
        if(len==0){
            int[][] ans=new int[1][];
            ans[0]=newInterval;
            return ans;
        }
        int[][] helper=new int[len+1][2];
        int j=0,i=0,flag=0;
        for(j=0;j<len+1;j++){     //得到插入区间后新数组，并保持有序  ，计数为新数组长度
            if(i<len&&intervals[i][0]<=newInterval[0]){       //要interval，i++
                helper[j]=intervals[i++];
                continue;
            }else if(i<len&&intervals[i][0]>newInterval[0]){  //要newInterval,i不动
                if(flag==0){
                    helper[j]=newInterval;
                    flag=1;
                }else{
                    helper[j]=intervals[i++];
                }
                continue;
            }
            helper[j]=(flag==0?newInterval:intervals[i]);   //最后一个位置，肯定是i或者new，所以看flag，不是new就是i。
        }
        i=0;j=0;  
        while(j<len+1){       //合并有序区间，双指针同向，i左边的都是处理好的数据
            if(i==0||helper[j][0]>helper[i-1][1]){    // 判断j位置和i-1位置是否有交集，没有交集则要j，并且更新i
                helper[i]=helper[j];
                i++;
            }else if(helper[j][0]<=helper[i-1][1]){ //有交集，不要j，且合并i-1和j的位置，i不动
                helper[i-1][1]=Math.max(helper[j][1],helper[i-1][1]);
            }
            j++;
        }
        intervals=new int[i][2];
        System.arraycopy(helper,0,intervals,0,i);
        return intervals;
