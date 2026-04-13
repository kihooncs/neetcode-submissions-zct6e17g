class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // map has o(n) because it store references of strings, not a copy
        for (String s : strs) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
        // space complexity is O(n*m) as it's returns n number of strings, and strings have m lengths
        // space complexity of data vs data that is being returned is different. O(n) vs O(n*m)
    }
    // time complexity: O(n*m) where n is number of strings and m is length of strings.
}
