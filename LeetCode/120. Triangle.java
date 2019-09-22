/**
* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
*
* For example, given the following triangle
*
*[
*     [2],
*    [3,4],
*   [6,5,7],
*  [4,1,8,3]
*]
*
*
*/
class Solution {
    //计算二维矩阵的最小路径，每次只能移动一步到相邻的位置上，（虽然我不知道这个有什么意义）
    //这个是典型的有重叠子问题的动态规划题目，从上到下，或者从上到下都可以，这里采取从下到上计算最小路径。（因为从上到下的话，到最后一行的时候还需要
    //遍历最小的那个）
    //其实最好的方法是再new一个数组出来存储每一行的结果，上一行会用到下一行的结果，但是Java深拷贝数组有点麻烦，所以我就直接在原数组上改了
    //从倒数第二行开始，每一个位置等于当前位置加上下一行相邻位置相加，取最小值，由此计算到第一行，第一行的数字即是结果
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2;i>=0;i--){
            for(int j=0;j<=i;j++){
              triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
