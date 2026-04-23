class Solution {
    public String minWindow(String s, String t) {
        int[] min = new int[2]; // storing index;
        int minNum = s.length() + 1; // storing min length of window 
        int start = 0;

        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();

        for (char c : t.toCharArray()) {
            countS.putIfAbsent(c, 0);
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int need = countT.keySet().size();
        int have = 0;

        for (int end = 0; end < s.length(); end++) {
            char curr = s.charAt(end);
            if (countS.containsKey(curr)) {
                countS.put(curr, countS.get(curr) + 1);
                if (countS.get(curr) == countT.get(curr)) {
                    have++;
                }
            }
            while (have == need) {
                int currWindowSize = end - start + 1;
                if (currWindowSize < minNum) {
                    minNum = currWindowSize;
                    min[0] = start;
                    min[1] = end + 1;
                }
                char charAtStart = s.charAt(start);
                start++;
                if (countS.containsKey(charAtStart)) {
                    countS.put(charAtStart, countS.get(charAtStart) - 1);
                    if (countS.get(charAtStart) < countT.get(charAtStart)) {
                        have--;
                    }
                }
            }
        }
        return s.substring(min[0], min[1]);
    }
}
