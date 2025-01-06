class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        int n = nums.size();
        long long sum = 0;
        long long ans = 0;
        int p = 0;
        int M[100001] = {0};
        for (int q = 0, t; q < n; q++) {
            sum += nums[q];
            ++M[t = nums[q]];
            while (M[t] > 1) {
                --M[nums[p++]];
            }
            if (q - p >= k - 1) {
                ans = max(ans, sum);
            }
            if (q >= k - 1) {
                sum -= nums[q - k + 1];
            }
        }
        return ans;
    }
};

auto init = []() {
    std ::ios ::sync_with_stdio(false);
    std ::cin.tie(nullptr);
    std ::cout.tie(nullptr);
    return 0;
}();
