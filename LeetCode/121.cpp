/*Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction 
(i.e., buy one and sell one share of the stock), design an algorithm to findthe 
maximum profit.
Note that you cannot sell a stock before you buy one. */

#include<vector>
#include<iostream>
#include<cstdlib>
using namespace std;


class Solution {
public:
    int maxProfit(vector<int>& prices) {
        /*  第一先用一个暴力法解决问题，不用想太多，但是时间花销就惨不忍睹
        if(!prices.size()||prices.size()==1) return 0;
        int result=prices[1]-prices[0],p;
        for(int i=0;i<prices.size()-1;i++)
        {
            p=prices[i];
            for(int j=i+1;j<prices.size();j++)
            {
                if(prices[j]-p>result)
                    result=prices[j]-p;
            }
        }
        if(result<=0)   return 0;
        */
       //用遍历更新利润的方法
       if(!prices.size()||prices.size()==1) return 0;   //设置先前条件，筛选一些无意义的计算数据
       int minprice=prices[0];                          //初始化股票最小价格                
       int profit=0;
       for(int i=1;i<prices.size();i++)                 //遍历数组
       {
           if(prices[i]<minprice)                       //如果当前价格小于最小价格，则更新最小价格
            minprice=prices[i];                         
            else if(prices[i]-minprice>profit)          //否则就是当前价格大于等于最小价格，再加判断条件，判断当前卖出利润是否大于现有利润，大于则更新现有利润
                profit=prices[i]-minprice;
       }
       return profit;
    }
};

int main()
{
    vector<int> prices{2,1};
    Solution so;
    cout<<so.maxProfit(prices)<<endl;
    system("pause");
    return 0;
}