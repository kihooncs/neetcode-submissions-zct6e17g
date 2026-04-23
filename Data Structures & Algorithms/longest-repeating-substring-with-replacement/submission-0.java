class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;
        int start = 0;
        int[] count = new int[26];
        for (int end = 0; end < s.length(); end++) {
            char currChar = s.charAt(end);
            count[currChar - 'A']++;
            while (end - start + 1 - findMax(count) > k) {
                // reduce length
                char startChar = s.charAt(start);
                count[startChar - 'A']--;
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    private int findMax(int[] count) {
        int max = 0;
        for (int c : count) {
            max = Math.max(max, c);
        }
        return max;
    }
}
