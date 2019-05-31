#include<iostream>
#include<string>
#include<cstdlib>
using namespace std;
class Solution {
public:
    string addBinary(string a, string b) {
        int len1=a.length();
        int len2=b.length();
        if(!len1) return b;
        if(!len2) return a;
        string::iterator it1=a.end()-1;
        string::iterator it2=b.end()-1;


        if(*it1=='1'&&*it2=='1')
            return this->addBinary(a.substr(0,len1--),b.substr(0,len2--))+"0";
        else if(*it1=='0'&&*it2=='0')
            return this->addBinary(a.substr(0,len1--),b.substr(0,len2--))+"0";
        else
        {
            return this->addBinary(a.substr(0,len1--),b.substr(0,len2--))+"1";
        }
        
            }
    
};

int main()
{
    Solution so;
    string a="0",b="0";
    cout<<so.addBinary(a,b)<<endl;
    system("pause");
    return 0;
}