class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int w1 = -1;
        int w2 = -1;
        int res = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            String s = wordsDict[i];
            if (s.equals(word1)) {
                w1 = i;
            }

            if (s.equals(word2)) {
                w2 = i;
            }

            if (w1 != -1 && w2 != -1) {
                res = Math.min(res, Math.abs(w1 - w2));
            }
        }
        return res;
    }
}
