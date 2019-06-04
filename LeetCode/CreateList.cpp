#include<iostream>
using namespace std;
struct ListNode{
    int val;
    struct ListNode *next;
    ListNode(int x):val(x),next(NULL){}
};
ListNode* CreateList(){
    ListNode *a=new ListNode(1);

    ListNode *b=new ListNode(1);
    a->next=b;
    ListNode *c=new ListNode(2);
    b->next=c;
    /*ListNode *d=new ListNode(3);
    c->next=d;
    ListNode *e=new ListNode(3);
    d->next=e;*/
    return a;


}