//合并区间，我没有弄清楚题目的条件，原数组并没有排好序
//如果是按照第一位排序，则可以用双指针，一个遍历原数组j，另一个用作新数组指针i，
//原数组指针的元素，只有两个选项，要还是不要，根据新数组元素判断
//如果i上是空的或者j的区间与i的没有交集，则j的元素直接压入新数组中；如果i和j的区间有重合，在i上则合并两者

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1)
            return intervals;
        Arrays.sort(intervals,(int[] a,int[] b)->a[0]-b[0]);      //第一次我没有排序，导致出很多问题
        List<int[]> ans=new ArrayList<>();
        int i=0,j=1;
        ans.add(intervals[0]);
        while(j<intervals.length){
            if(i>ans.size()){
                ans.add(intervals[j]);
            }
            else if(intervals[j][0]<=ans.get(i)[1]){      //排序后这里比较就简单多了
                ans.get(i)[1]=Math.max(intervals[j][1],ans.get(i)[1]);      //第一个元素是有序的，因此不用再比较
            }else{
                ans.add(intervals[j]);
                i++;
            }
            j++;
        }
        return ans.toArray(new int[0][]);
    }
}
