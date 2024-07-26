//56. Merge Intervals
/*
这道题我的思路是，先排序，根据二维数组第一列来排序，再两两合并，第一个数组的第二位和第二个数组的数字比较，进行合并
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        
        if(!intervals.size())
            return intervals;
        vector<vector<int>> interval=intervals;
        //可以直接用sort排序，比较方便，我自己写了快速排序，两种比较后我发下还是我的快排稍微快那么一丢丢，虽然两个的结果都慢的像蜗牛一样
        quicksort_array(interval,0,interval.size()-1);
        for(int i=0;i<interval.size()-1;i++){
            vector<vector<int> >::iterator it=interval.begin();
            //比较第一数组和第二个数组的第一列数字，若介于第二个数组中间的话，就取第一个数组的第一个数组和第二个数组的第二个数字组成新的数组插入原位置，并删除原来两个数组
            if(interval[i][1]>=interval[i+1][0]&&interval[i][1]<=interval[i+1][1])
            {
                vector<int>temp;
                temp.push_back(interval[i][0]);
                temp.push_back(interval[i+1][1]);
                interval.erase(it+i);
                interval.erase(it+i);
                interval.insert(it+i,temp);
                i--;
            }
            //如果在第二个数组的右边，则直接删除第二个数组即可
            else if(interval[i][1]>=interval[i+1][0]&&interval[i][1]>interval[i+1][1])
            {interval.erase(it+i+1);
             i--;}
            
        }
        return interval;
    }
    //快速排序
    void quicksort_array(vector<vector<int>>& intervals,int low,int high){
        if(low>high)
            return;
        int i=low,j=high;
        vector<int> temp=intervals[i];
        while(i<j){
            
            while(i<j&&intervals[j][0]>=temp[0])
                j--;
            if(i<j)
            {
                intervals[i]=intervals[j];
                i++;
            }
            while(i<j&&intervals[i][0]<=temp[0])
                i++;
            if(i<j)
                intervals[j]=intervals[i];
            j--;
        }
        intervals[i]=temp;
        quicksort_array(intervals,low,i-1);
        quicksort_array(intervals,i+1,high);
    }

   
    
};
