/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
*/


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    //遍历二维数组，查找元素，二维数组有序
        //空数组返回false
        if(matrix.length==1&&matrix[0].length==0)
            return false;
        //遍历二维数组每一行的最后一个元素temp，如果target小于temp,则在这一行里进行二分查找，若大于temp,则往下遍历
        for(int i=0;i<matrix.length;i++){
            int temp=matrix[i][matrix[i].length-1];
            //等于temp则返回true
            if(target==temp)    
                return true;
            else if(target<temp){
                return midSearch(matrix[i],0,matrix[i].length-1,target);
            }
                
        }
        //最后遍历完二维数组也没有，则不存在该元素
        return false;
    }
    private boolean midSearch(int[] matrix,int low,int high,int target){
    //二分查找
        //查找失败条件
        if(low>high)
            return false;
        int mid=(low+high)/2;
        //查找成功条件
        if(matrix[mid]==target)
            return true;
        //折半查找
        if(matrix[mid]>target)
            return midSearch(matrix,low,mid-1,target);
        else if(matrix[mid]<target)
            return midSearch(matrix,mid+1,high,target);
        return false;
    }
}
