#include<iostream>
#include<vector>
#include<cstdlib>
using namespace std;
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int flag=0;
        int i;
        for(int j=0;j<n;j++)
        {
            vector<int>::iterator it1=nums1.begin();
            flag=0;
            for(i=0;i<m;i++)
            {
                
                if(nums2[j]<nums1[i])
                {
                    nums1.insert(it1,nums2[j]);
                    m++;
                    flag=1;
                    break;
                }
                it1++;
            }
            if(!flag&&i==m)
            {
                nums1.insert(it1,nums2[j]);
                m++;
            }
        }
        nums1.erase(nums1.begin()+m,nums1.end());
    }
};

int main()
{
    vector<int> nums1={1,2,3,0,0,0};
    vector<int> nums2={2,5,6};
    Solution so;
    so.merge(nums1,3,nums2,3);
    for(vector<int>::iterator it=nums1.begin();it!=nums1.end();it++)
        cout<<*it<<" ";
    system("pause");
    return 0;
}



