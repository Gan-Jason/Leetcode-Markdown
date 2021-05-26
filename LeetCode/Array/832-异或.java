//这题主要还是位运算影响大一点，能用位运算就用位运算，会快一点

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for(int i=0;i<image.length;i++){
            int p=0,q=image[i].length-1;
            while(p<q){
                int t=image[i][p];
                image[i][p]=image[i][q];
                image[i][q]=t;
                image[i][p]^=1;
                image[i][q]^=1;
                p++;
                q--;
            }
            if(p==q)image[i][p]^=1;
        }
        return image;
    }
}
