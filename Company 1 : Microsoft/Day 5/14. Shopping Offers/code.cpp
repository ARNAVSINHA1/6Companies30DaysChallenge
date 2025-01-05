class Solution {
public:
    map<vector<int>, int> mp;
    int solve(vector<int>& price, vector<vector<int>>& special,
              vector<int> needs) {
        int n = price.size();
        int cost = INT_MAX;
        vector<int> v = needs;

        if (mp.find(needs) != mp.end())
            return mp[needs];

        for (int i = 0; i < special.size(); i++) {
            bool flag = true;
            int totalPrice = 0;
            for (int j = 0; j < n; j++) {
                if (special[i][j] > needs[j])
                    flag = false;
                totalPrice += (price[j] * needs[j]);
            }

            if (flag && totalPrice > special[i][n]) {
                for (int j = 0; j < n; j++) {
                    v[j] = needs[j] - special[i][j];
                }
                cost = min(cost, special[i][n] + solve(price, special, v));
            }
        }

        if (cost == INT_MAX) {
            cost = 0;
            for (int i = 0; i < n; i++) {
                cost += price[i] * needs[i];
            }
        }

        return mp[needs] = cost;
    }
    int shoppingOffers(vector<int>& price, vector<vector<int>>& special,
                       vector<int>& needs) {
        int cost = 0, n = price.size();
        for (int i = 0; i < n; i++) {
            cost += (price[i] * needs[i]);
        }
        cost = min(cost, solve(price, special, needs));
        return cost;
    }
};
