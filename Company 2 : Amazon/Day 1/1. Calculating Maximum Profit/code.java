class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] buy = new int[k];
        int[] sell = new int[k];

        for (int i = 0; i < k; ++i)
            buy[i] = Integer.MIN_VALUE;

        for (int price : prices) {
            buy[0] = Math.max(buy[0], -price);
            sell[0] = Math.max(sell[0], buy[0] + price);
            for (int i = 1; i < k; ++i) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }

        return sell[k - 1];
    }
}
