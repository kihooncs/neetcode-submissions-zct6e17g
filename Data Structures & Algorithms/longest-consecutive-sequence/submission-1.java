class Solution {
    public int longestConsecutive(int[] nums) {
        // [2, 20, 4, 10, 3, 4, 5]
        // [0, 3, 2, 5, 4, 6, 1, 1]

        // store all in hash set
        // for each element, if element is start of sequence, evaluate sequence 
        // if not, move onto next item
        // time complexity:
        // best case: all elments are NOT sequence of each other -> O(n) time and O(n) space for set
        // worst case: all elements are sequence of each other [1, 2, 3, 4, 5...] -> 
        // (n - 1) + 1 + 1 + 1 + 1 + 1 + 1 + 1 = n
        // each elment is visited 2 times at most 

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int seqLength = 1;
                while (set.contains(n + seqLength)) {
                    seqLength++;
                }
                longest = Math.max(longest, seqLength);
            }
        }
        return longest;
    }
}
