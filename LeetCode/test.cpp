#include<iostream>
#include<string>
#include<vector>
using namespace std;
int main()
{
    vector<vector<int> > test;
    vector<int> temp;
    temp.push_back(8);
    test.push_back(temp);
    for(int i=0;i<test.size();i++)
    {
    for(int j=0;j<test[i].size();j++)
            cout<<test[i][j]<<" ";
    cout<<endl;
    }
    system("pause");
    return 0;
}