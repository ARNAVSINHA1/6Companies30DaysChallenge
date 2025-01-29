//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    string encode(string s) {
        // code here
        int n = s.size();
        string ans = "";
        for(int i =0;i< s.size();i++)
        {
            int count = 1;
            while(i+1 < n and s[i] == s[i+1])
            {
                count++;
                i++;
            }
            ans += s[i];
            ans += to_string(count);
        }
        return ans;
    }
};


//{ Driver Code Starts.

int main(){
    int t;
    scanf("%d ",&t);
    while(t--){
        
        string s;
        getline(cin,s);
        
        Solution obj;
        string res = obj.encode(s);
        
        cout<<res<<"\n";
        
    
cout << "~" << "\n";
}
}

// } Driver Code Ends