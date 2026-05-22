class WordDistance {
    private Map<String, List<Integer>> map;

    public WordDistance(String[] wordsDict) {
        this.map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            String curr = wordsDict[i];
            this.map.putIfAbsent(curr, new ArrayList<>());
            this.map.get(curr).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> loc1 = this.map.get(word1);
        List<Integer> loc2 = this.map.get(word2);

        int res = Integer.MAX_VALUE;
        int l1 = 0;
        int l2 = 0;

        while (l1 < loc1.size() && l2 < loc2.size()) {
            res = Math.min(res, Math.abs(loc1.get(l1) - loc2.get(l2)));
            if (loc1.get(l1) > loc2.get(l2)) {
                l2++;
            } else {
                l1++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
