//这一题需要理清思路，同一个小时内的就直接计算分钟；不同小时的分两种情况：1. 通宵了；2. 当日；如果是通宵了就分两个时间段计算，如果是当日：先计算开始的那个小时玩的局数，再计算结束那个小时的局数
//中间有整的小时的话就计算小时*4
//一个关键点，对开始时间向上最近的一个15倍数取入，比如03分就取为15分，17分就取为30分，这里有技巧的，(startMinute+14)/15*15即可。如果不用这种就分几个情况判断。


class Solution {
    public int numberOfRounds(String startTime, String finishTime) {
        int startHour=Integer.parseInt(startTime.substring(0,2));
        int startMinute=Integer.parseInt(startTime.substring(3,5));
        int endHour=Integer.parseInt(finishTime.substring(0,2));
        int endMinute=Integer.parseInt(finishTime.substring(3,5));
        int ans=0;
        if(startHour>endHour||startHour==endHour&&startMinute>endMinute){
            ans+=count(0,24,startMinute,startHour)+count(endMinute,endHour,0,0);
        }else{
            ans+=count(endMinute,endHour,startMinute,startHour);
        }
        return ans;
    }
    int count(int endMinute,int endHour,int startMinute,int startHour){
        int ans=0;
        int minute=0;
        if(startHour==endHour){
            minute=endMinute-(startMinute+14)/15*15;        //向上舍入
            ans+=minute/15;
        }else{
            //这里递归调用了一次本身，注意同一个小时内开始/结束时间的取值
            ans+=count(60,startHour,startMinute,startHour)+count(endMinute,endHour,0,endHour)+(endHour-startHour-1)*4;    
            
        }
        return ans;
    }
}
