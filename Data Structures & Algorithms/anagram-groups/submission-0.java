class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char currChar = s.charAt(i);
                int diff = (int) (currChar - 'a');
                freq[diff] += 1;
            }
            String key = Arrays.toString(freq);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
