//这题关键点在于数组前缀和，也就是matrix[i][j]到matrix[0][0]构成的元素和，用于计算矩阵中某个矩形的元素和时的时间复杂度为o(1)
//这题用二分，如果给一个边长后去遍历二维数组，找符合条件的正方形，用几个循环的话会超时，因此需要把一些有用的计算结果记录下来，便于后面使用
//前缀和的公式是：prefix[i][j]=mat[i][j]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];



class Solution {
    public  int maxSideLength(int[][] mat, int threshold) {
        int left=0,right=Math.min(mat.length,mat[0].length),mid;
        int[][] prefix=new int[mat.length][mat[0].length];
        prefix[0][0]=mat[0][0];
        for(int i=0;i<prefix.length;i++){
            for(int j=0;j<prefix[0].length;j++){
                if(i==0&&j>0){      //初始化上边界
                    prefix[i][j]+=mat[i][j]+prefix[i][j-1];
                }else if(j==0&&i>0){  //初始化左边界
                    prefix[i][j]+=mat[i][j]+prefix[i-1][j];
                }else if(i>0&&j>0){   //从（1，1）开始，这个公式成立
                    prefix[i][j]=mat[i][j]+prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1];
                }
            }
        }
        while(left<right){  //正方形的边长范围在[0,min(matrixL,matrixW)];
            mid=left+(right-left+1)/2;    //这里要保留左边界，因此要取上半区
            if(check(mat,mid,threshold,prefix)){    //判断该边长是否满足条件：正方形的元素和<=threshold，满足的话说明边长给小了并保留当前答案
                left=mid;
            }else{    //否则边长给大了
                right=mid-1;
            }
        }
        return left;
    }
    private boolean check(int[][] mat,int mid,int threshold,int[][] prefix){
        int sum=0;
        if(mid==1){     //边长为1时，只需判断matrix的值
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    if(mat[i][j]<=threshold)return true;
                }
            }
        }else{
            for(int i=0;i<=mat.length-mid;i++){
                for(int j=0;j<=mat[0].length-mid;j++){
                    if(i==0&&j==0){         //顶点在原点处，prefix的值就是正方形的元素和
                        sum=prefix[i+mid-1][j+mid-1];
                    }else if(i==0&&j>0){       //顶点在上边界，减去正方形左边空白的元素和
                        sum=prefix[i+mid-1][j+mid-1]-prefix[i+mid-1][j-1];
                    }else if(i>0&&j==0){        //顶点在做边界，减去正方形上面空白的元素和
                        sum=prefix[i+mid-1][j+mid-1]-prefix[i-1][j+mid-1];
                    }
                    else{       //顶点在(1,1)之后
                        sum=prefix[i+mid-1][j+mid-1]-prefix[i-1][j+mid-1]-prefix[i+mid-1][j-1]+prefix[i-1][j-1];
                    }
                    if(sum<=threshold)return true;
                }
            }
        }
        return false;
    }
}
