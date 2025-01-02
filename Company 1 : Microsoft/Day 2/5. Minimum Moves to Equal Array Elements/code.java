class Solution {
    public int minMoves2(int[] nums) {
        int length = nums.length, result = 0, median = helper(nums, 0, length - 1, (length - 1) / 2);
        for (int x : nums) {
            result += Math.abs(x - median);
        }
        return result;
    }
    private int helper(int[] q, int l, int r, int k) {
        if (l >= r) 
            return q[r];
        int x = q[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x) ;
            while (q[--j] > x) ;
            if (i < j) {
                int t = q[i];
                q[i] = q[j];
                q[j] = t;
            }
        }
        if (k <= j) 
            return helper(q, l, j, k);
        return helper(q, j + 1, r, k);
    }
}
