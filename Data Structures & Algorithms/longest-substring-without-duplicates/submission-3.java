class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, start = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            } else {
                while (set.contains(c)) {
                    set.remove(s.charAt(start));
                    start++;
                }
                set.add(c);
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
