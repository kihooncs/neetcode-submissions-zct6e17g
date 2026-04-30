class Solution {
    public int findMin(int[] nums) {
        int l = 0; int r = nums.length - 1;
        int res = nums[0];

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[l] < nums[r]) { //sorted array
                res = Math.min(res, nums[l]);
                break;
            } else 
            if (nums[l] <= nums[mid]) { // left sorted, look right
                l = mid + 1;
            } else { // nums[l] > nums[mid] -> [3, 4, 0, 1, 2]
                r = mid - 1; 
            }
            res = Math.min(res, nums[mid]);
        }
        return res;
    }
}
