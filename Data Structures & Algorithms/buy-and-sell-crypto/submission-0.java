class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buy = prices[0];
        int sell = prices[0];
        for (int p : prices) {
            sell = p;
            max = Math.max(max, sell - buy);
            if (p < buy) {
                buy = p;
            }
        }

        return max;
    }
}
