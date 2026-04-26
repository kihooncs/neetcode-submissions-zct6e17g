class Solution {
    public String mergeAlternately(String word1, String word2) {
        String result = "";
        int i1 = 0;
        int i2 = 0;
        while (i1 < word1.length() && i2 < word2.length()) {
            result += word1.charAt(i1);
            result += word2.charAt(i2);
            i1++;
            i2++;
                    }
        result += word1.substring(i1, word1.length()) + word2.substring(i2, word2.length());
        return result;
    }
}