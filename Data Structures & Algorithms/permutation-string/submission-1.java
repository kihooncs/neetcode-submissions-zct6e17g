class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int matches = 0;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        if (matches == 26) {
            return true;
        }

        int start = 0;
        for (int end = s1.length(); end < s2.length(); end++) {
            char startChar = s2.charAt(start);
            s2Count[startChar - 'a']--;
            start++;
            if (s2Count[startChar - 'a'] == s1Count[startChar - 'a']) {
                matches++;
            } else if (s2Count[startChar - 'a'] + 1 == s1Count[startChar - 'a']) {
                matches--;
            }

            char endChar = s2.charAt(end);

            s2Count[endChar - 'a']++;

            if (s2Count[endChar - 'a'] == s1Count[endChar - 'a']) {
                matches++;
            } else if (s2Count[endChar - 'a'] - 1 == s1Count[endChar - 'a']) {
                matches--;
            }

            if (matches == 26) {
                return true;
            }
        }
        return matches == 26;
    }
}
