#include <iostream>
#include <vector>
#include<string>
using namespace std;
int main(){
    string a ;
    cin>>a;
    vector<int>b(3,0);
    int i=0,j=0,c=0,l=a.length();
    while(j<l){
        b[a[j]-'a']++;
        while(b[0]>=1 && b[1]>=1 && b[2]>=1){
            c=c+l-j;
            b[a[i]-'a']--;
            i++;
         }
         j++;
     }
     cout<<c;    
}
