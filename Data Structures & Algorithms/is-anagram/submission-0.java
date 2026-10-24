class Solution {
    public boolean isAnagram(String s, String t) {
        // if length of s and t is different, return false
        // create an integer array with size of 26
        // iterate through s and increment each index for every character
        // iterate through t and decrement each index for every character
        // if at any given time, value at index i is negative, return false
        // at the end return true
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            int i = c - 'a';
            count[i]++;
        }

        for (char c : t.toCharArray()) {
            int i = c - 'a';
            count[i]--;
            if (count[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
