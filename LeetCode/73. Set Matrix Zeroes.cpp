/*
*Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
*/

class Solution {
  public void setZeroes(int[][] matrix) {
  
  //把二维矩阵的行列中有0的行列全部置零
    int R = matrix.length;
    int C = matrix[0].length;
    //开辟空间存放有零的行和列号
    Set<Integer> rows = new HashSet<Integer>();
    Set<Integer> cols = new HashSet<Integer>();

    // Essentially, we mark the rows and columns that are to be made zero
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          cols.add(j);
        }
      }
    }

    // Iterate over the array once again and using the rows and cols sets, update the elements.
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
      //遍历矩阵，若当前位置的行列号是存在于标记集合中，则置零
        if (rows.contains(i) || cols.contains(j)) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}
