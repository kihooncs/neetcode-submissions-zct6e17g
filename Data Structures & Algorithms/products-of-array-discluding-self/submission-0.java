class Solution {
    public int[] productExceptSelf(int[] nums) {
        // get the total product of nums -> O(n) time where n is # of elements in nums
        // itrate through nums and divide current value at index i
        // [1, 2, 4, 6] with 48 as total product. at index 1 (value 2), we can
        // divide 48 with 2 -> 24.

        // brute force approach would be
        // for each element, multiply the rest of elements in the array.
        // we need to iterate through n-1 elements for n times where n is total 
        // number of elements. Thus, O(n^2-n) -> O(n^2)

        int product = 1; // since constraints is 2 <= nums.length

        // what if current number is 0?  
        // case #1: # of 0 -> none -> use our approach
        // case #2 : # of 0 -> 1 -> every result would be 0 except 0 itself
        // case #3: # of 0 -> 2+ -> [1, 0, 1, 0, 1] -> every result is 0

        int countOfZero = 0;

        int[] result = new int[nums.length];

        for (int n : nums) {
            if (n == 0) {
                countOfZero++;
            } else {
                product *= n;
            }

            if (countOfZero > 1) {
                return result;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (countOfZero == 0) {
                result[i] = product / nums[i];
            } else {
                if (nums[i] == 0) {
                    result[i] = product;
                }
            }
        }
        return result;
    }
}  
