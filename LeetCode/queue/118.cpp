/*Given a non-negative integer numRows,
 generate the first numRows of Pascal's triangle. */

 #include<vector>
 using namespace std;

class Solution {
public:
    vector<vector<int>> generate(int numRows) {    //循环两层数组求杨辉三角
        vector<vector<int> >triangle;
        if(!numRows)
            return triangle;
        vector<int> row;
        row.push_back(1);                          //杨辉三角每一行都是以1开头，以1结尾
        triangle.push_back(row);
        row.clear();                                //row是存储每一行的数组
        for(int rowNum=1;rowNum<numRows;rowNum++)   //求行数为numRows的杨辉三角
        {
            row.push_back(1);                       //以1开头
            for(int j=1;j<rowNum;j++)
            {
                row.push_back(triangle[rowNum-1][j]+triangle[rowNum-1][j-1]);   //除了开头结尾的元素外，该行j列元素是上一行的j列元素与j-1列元素之和
            }
            row.push_back(1);                       //1结尾
            triangle.push_back(row);
            row.clear();
        }
        return triangle;
    }
};

//杨辉三角的队列实现
#include<queue>

    vector<vector<int>> generate(int numRows) { 
    queue<int> qu;
    vector<vector<int>> triangle;
    if(!numRows) return triangle;
    vector<int> row;
    row.push_back(1);   
    triangle.push_back(row);        //初始化杨辉三角第一行
    if(numRows==1) return triangle;
    row.clear();
    row.push_back(1);
    row.push_back(1);
    triangle.push_back(row);        //初始化第二行
    if(numRows==2) return triangle;
    int p,q;
    qu.push(0);                     //以第二行的元素进队，每一层以前后为0来标识一层的结束
    qu.push(1);
    qu.push(1);
    qu.push(0);
    for(int i=2;i<numRows;i++)      //numROWS大于两行时进行循环
    {
        row.clear();
        do
        {
            q=qu.front();           //遍历队头两个元素，相加后分别进队，进数组
            qu.pop();               //队头元素出队，每次只出队一个
            p=qu.front();
            qu.push(q+p);   
            row.push_back(q+p);

        } while (p);                //当遍历第二个元素不为零时继续循环，表明当前层未结束
        qu.push(0);                 //每一层以零结尾
        triangle.push_back(row);    //把当前层压进二维数组
    }
    return triangle;
    }
