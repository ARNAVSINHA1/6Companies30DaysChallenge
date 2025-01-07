#include <iostream>
#include <vector>
#include <string>
#include <limits>
#include <sstream>

using namespace std;

class Pair {
public:
    string first;
    int second;

    Pair(string first, int second) : first(first), second(second) {}
};

class GFG {
private:
    static int get(int p[], int n) {
        vector<vector<int>> m(n, vector<int>(n, 0));
        int ans = 1000000000;

        for (int i = 1; i < n; i++) m[i][i] = 0;

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                m[i][i + L - 1] = INT_MAX;

                for (int k = i; k <= i + L - 2; k++) {
                    int q = m[i][k] + m[k + 1][i + L - 1] + p[i - 1] * p[k] * p[i + L - 1];

                    if (q < m[i][i + L - 1]) {
                        m[i][i + L - 1] = q;
                    }
                }
            }
        }

        return m[1][n - 1];
    }

    static int find(const string& s, int p[]) {
        vector<int*> arr;
        int ans = 0;

        for (char t : s) {
            if (t == '(') {
                arr.push_back(new int[2]{-1, -1});
            } else if (t == ')') {
                int* b = arr.back(); arr.pop_back();
                int* a = arr.back(); arr.pop_back();
                arr.pop_back();
                arr.push_back(new int[2]{a[0], b[1]});
                ans += a[0] * a[1] * b[1];
            } else {
                arr.push_back(new int[2]{p[t - 'A'], p[t - 'A' + 1]});
            }
        }

        return ans;
    }

public:
    static void main() {
        int t;
        cin >> t;
        cin.ignore();

        while (t-- > 0) {
            string line;
            getline(cin, line);
            istringstream iss(line);
            vector<int> nums((istream_iterator<int>(iss)), istream_iterator<int>());

            string result = matrixChainOrder(nums.data());
            if (get(nums.data(), nums.size()) == find(result, nums.data())) {
                cout << "true" << endl;
            } else {
                cout << "false" << endl;
            }
        }
    }

    static Pair cal(int p[], Pair** dp, int i, int j) {
        if (i == j) {
            string st = "";
            st += (char)('A' + i - 1);
            return Pair(st, 0);
        }

        if (dp[i][j].second != -1) {
            return dp[i][j];
        }

        int max = INT_MAX;
        string sr = "";

        for (int k = i; k < j; k++) {
            Pair pr1 = cal(p, dp, i, k);
            Pair pr2 = cal(p, dp, k + 1, j);
            int x = pr1.second + pr2.second + p[i - 1] * p[k] * p[j];
            string s = "(" + pr1.first + pr2.first + ")";
            if (max > x) {
                max = x;
                sr = s;
            }
        }

        dp[i][j] = Pair(sr, max);
        return dp[i][j];
    }

    static string matrixChainOrder(int p[]) {
        int n = sizeof(p) / sizeof(p[0]);
        Pair** dp = new Pair*[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new Pair[n];
            for (int j = 0; j < n; j++) {
                dp[i][j] = Pair("", -1);
            }
        }

        Pair pr = cal(p, dp, 1, n - 1);
        return pr.first;
    }
};

int main() {
    GFG::main();
    return 0;
}

