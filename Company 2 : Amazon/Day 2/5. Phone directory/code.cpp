//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class trieNode{
    public: 
    
    trieNode* children[26];
    bool isEnd;
    
    trieNode(){
        for(int i=0;i<26;i++){
            this->children[i]=NULL;
        }
        this->isEnd=false;
    }
};
class Solution{
public:
    trieNode* root;
    
    Solution(){
        root=new trieNode();
    }
    
    void insert(string s){
        int n=s.size();
        trieNode* curr=root;
        for(int i=0;i<n;i++){
            char ch=s[i];
            if(curr->children[ch-'a']==NULL){
                curr->children[ch-'a']=new trieNode();
            }
            
            curr=curr->children[ch-'a'];
        }
        
        curr->isEnd=true;
    }

    trieNode* prefix(string s){
        int n=s.size();
        trieNode* curr=root;
        for(int i=0;i<n;i++){
            char ch=s[i];
            if(curr->children[ch-'a']==NULL){
                return NULL;
            }
            curr=curr->children[ch-'a'];
        }
        
        return curr;
    }
    
    void prefixSearch(vector<string> &s,string &str,trieNode* curr){
        if(curr->isEnd){
                s.push_back(str);
        }
        
        for(int i=0;i<26;i++){
            if(curr->children[i]){
                str.push_back(i+'a');
                trieNode* temp=curr;
                prefixSearch(s,str,curr->children[i]);
                str.pop_back();
                curr=temp;
            }
        }
        return;
    }

    vector<vector<string>> displayContacts(int n, string contact[], string s)
    {
        vector<vector<string>> res;
        for(int i=0;i<n;i++){
            insert(contact[i]);
        }
        string str;
        for(int i=0;i<s.size();i++){
            str.push_back(s[i]);
            trieNode* curr=prefix(str);
            vector<string> v;
            if(!curr){
                v.push_back("0");
                res.push_back(v);
            }
            else{
                prefixSearch(v,str,curr);
                res.push_back(v);
            }
        }
        
        return res;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        string contact[n], s;
        for(int i = 0;i < n;i++)
            cin>>contact[i];
        cin>>s;
        
        Solution ob;
        vector<vector<string>> ans = ob.displayContacts(n, contact, s);
        for(int i = 0;i < ans.size();i++){
            for(auto u: ans[i])
                cout<<u<<" ";
            cout<<"\n";
        }
    
cout << "~" << "\n";
}
    return 0;
}
// } Driver Code Ends
