class Solution {
    public int comb(int n, int k) {
        if (k < 0 || k > n)
            return 0;
        long res = 1;
        for (int i = 0; i < k; i++) {
            res = res * (n - i) / (i + 1);
        }
        return (int) res;
    }

    public int waysToReachStair(int k) {
        int res = 0;
        for (int i = 0; i < 30; i++) {
            res += comb(i + 1, (1 << i) - k);
        }
        return res;
    }
}
