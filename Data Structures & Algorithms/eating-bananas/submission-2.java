class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // find max pile
        int maxPile = 0;
        for (int p : piles) {
            maxPile = Math.max(maxPile, p);
        }

        // in the worst case scenario, koko can eat maxPile bananas per hour since piles.length <= h
        int res = maxPile;
        int l = 1;
        int r = maxPile;

        // binary search
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int k = mid;
            long currHour = 0;

            // compute total number of hours to eat all piles with k speed
            for (int p : piles) {
                currHour += Math.ceil((double) p / k);
            }
            if (currHour <= h) { // search left as we don't need to consider bigger k
                res = Math.min(res, k);
                r = mid - 1;
            } else { //currHour > h, search right as we need to consider bigger k
                l = mid + 1;
            }
        }
        
        return res;
    }
}
