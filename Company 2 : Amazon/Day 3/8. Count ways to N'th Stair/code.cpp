class Solution {
public:
    long long nCr(int n, int r) {
        r = max(r, n - r);
        long long ans = 1;
        for (int i = 1; i <= r; i++) {
            ans *= (n - r + i);
            ans /= i;
        }
        return ans;
    }
    int waysToReachStair(int k) {
        if (k == 0 || k == 4)
            return 2;
        else if (k == 1 || k == 2)
            return 4;
        else {
            long long r = pow(2, ceil(log2(k))) - k;
            if (r < 0 || r > ceil(log2(k)) + 1)
                return 0;
            else
                return nCr(ceil(log2(k)) + 1, r);
        }
    }
};
