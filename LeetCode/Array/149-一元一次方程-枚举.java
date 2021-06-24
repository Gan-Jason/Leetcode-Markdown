//枚举两个点求直线方程，再枚举第三个点求是否在直线上
//一元一次方程：y=kx+b,两点确定一直线-> y1=kx1+b,y2=kx2+b，->
//k=(y2-y1)/(x2-x1)
//b=(x2y1-x1y2)/(x2-x1)
//由于k和b可能是分数(不是整数),为了保证精度，k和b不做除法运算，自定义数据结构保存分数，最后判断时再做除法
//卡住的地方，最后求分数的值时没注意小数的情况，如果是小数就失去精度导致判断出错，比如2/9==0，最后结果累加错误
//遇到测试用例卡在最后几个时，检查边界条件，比如小数、负数、溢出等，除法是否失去精度，最好是检查代码，不要轻易跑测试用例，容易太依赖测试用例


class Solution {
    private Fenshu k;       //声明k
    private Fenshu b;       //b
    private boolean tag;    //用于判断是否为斜率不存在的情况，即平行于y轴的直线
    private int x;          //用于斜率不存在时，保存x
    public int maxPoints(int[][] points) {
        int len=points.length;
        if(len<=2){
            return len;
        }
        int ans=0;
        for(int i=0;i<len;i++){
            int[] p1=points[i];     //第一个点
            int sum=1;
            for(int j=i+1;j<len;j++){
                int[] p2=points[j];     //第二个点，直线确定
                sum=2;
                help(p1,p2);        //求出该直线的k和b
                for(int k=j+1;k<len;k++){
                    if(tag){        //如果k不存在，则判断剩下的点是否在直线上
                        if(points[k][0]==x){
                            sum++;
                        }
                    }
                    else if(isLine(points[k])){     //k存在，判断是否在直线上
                        sum++;
                    }
                }
                ans=Math.max(ans,sum);
            }
        }
        return ans;
    }
    private void help(int[] p1,int[] p2){
        int x1=p1[0],y1=p1[1],x2=p2[0],y2=p2[1];
        if(x1==x2){     //此时k不存在
            tag=true;
            x=x1;
            return;
        }else{
            tag=false;
        }
        k=new Fenshu(y2-y1,x2-x1);      //求k公式
        b=new Fenshu(x2*y1-x1*y2,x2-x1);    //求b公式
    }
    private boolean isLine(int[] p){    //把点p带入y=kx+b中看是否成立
        int den=k.den*b.den;    
        int num=k.num*p[0]*b.den+k.den*b.num;
        if(num%den==0){     //这里要注意结果是否为小数，是的话则直接返回false...前提是点都是整数的...如果点的坐标存在小数就gg了
            if(num/den==p[1])
                return true;
        }
        return false;
    }
    private class Fenshu{
        public int num;
        public int den;
        public Fenshu(int num,int den){
            this.num=num;
            this.den=den;
        }
    }
}

