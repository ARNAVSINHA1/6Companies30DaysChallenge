#define view_a(a) for(auto&x:a) cout<<x<<" "
#define view_a2(a) for(auto&x:a){ for(auto&y:x) { cout<<y<<" "; } cout<<endl; }
int speedup = [] {ios::sync_with_stdio(0); cin.tie(0); return 0;}();

class Solution {
public:
    int maxEnvelopes(vector<vector<int>>& envelopes) {
        int n = envelopes.size();
        vector<pair<int, int>> Lis;
        for (int i = 0; i < n; ++i) {
            Lis.push_back({envelopes[i][0], envelopes[i][1]});
        }
        sort(Lis.begin(), Lis.end(),[&](auto L1, auto L2){return L1.first < L2.first || (L1.first == L2.first && L1.second > L2.second);});
        vector<int> R;
        R.push_back(Lis[0].second);
        for (int i = 1; i < n; ++i) {
            if (Lis[i].second > R.back()) {
                R.push_back(Lis[i].second);
            } else {
                vector<int>::iterator index = lower_bound(R.begin(), R.end(), Lis[i].second);
                R[index-R.begin()] = Lis[i].second;
            }
        }
        return R.size();
    }
};
