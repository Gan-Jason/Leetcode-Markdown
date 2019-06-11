/*Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 (i.e., buy one and sell one share of the stock multiple times).
Note: You may not engage in multiple transactions at the same time 
(i.e., you must sell the stock before you buy again) */

#include<vector>
using namespace std;
class Solution {
public:
    int maxProfit(vector<int>& prices) {            //这种方法是只要都利润就交易，不管利润多少，总的利润加起来就是最大的利润
        int profit=0;                       
        for(int i=1;i<prices.size();i++)
        {
            if(prices[i]>prices[i-1])               //只遍历一次数组，找到钱可赚的交易日，多贪蝇头小利，积少成多
                profit+=prices[i]-prices[i-1];
            
        }
        return profit;
    }
};