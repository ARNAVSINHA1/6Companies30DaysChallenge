//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution
{
public:
    string printMinNumberForPattern(string S)
    {
        // code here
        string ans = "";
        for (int i = 1; i <= S.size() + 1; i++)
        {
            ans += '0' + i;
        }
        while (true)
        {
            int j = 1, k = 0;
            bool f = true;
            while (j < ans.size())
            {
                if (S[k] == 'D' && ans[j] > ans[j - 1])
                {
                    swap(ans[j], ans[j - 1]);
                    f = false;
                }
                if (S[k] == 'I' && ans[j] < ans[j - 1])
                {
                    swap(ans[j], ans[j - 1]);
                    f = false;
                }
                j++;
                k++;
            }
            if (f == true)
                break;
        }
        return ans;
    }
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string S;
        cin >> S;
        Solution ob;
        cout << ob.printMinNumberForPattern(S) << endl;

        cout << "~" << "\n";
    }
    return 0;
}

// } Driver Code Ends