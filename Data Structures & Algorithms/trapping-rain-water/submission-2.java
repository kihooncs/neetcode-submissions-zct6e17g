class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxR = 0;
        int maxL = 0;
        int res = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                int currHeight = height[l];
                res += Math.max(0, maxL - currHeight);
                maxL = Math.max(maxL, currHeight);
                l++;
            } else { // maxL > maxR
                int currHeight = height[r];
                res += Math.max(0, maxR - currHeight);
                maxR = Math.max(maxR, currHeight);
                r--;
            }
        }
        return res;
    }
}